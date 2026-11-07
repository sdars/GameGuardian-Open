package com.gg.freezeprobe;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

/**
 * Test bed for the freeze of GameGuardian.
 *
 * The value that the panel searches for lives in an int array of the heap
 * of the process.  The panel of the app skips the spaces of the runtime
 * that are not moved by the garbage collector ("dalvik-non moving space"),
 * so the value has to live in the heap to be found by the search.
 *
 * The layout of the buffer:
 *
 *   0   the value (a dword) - this is what the search finds
 *   1   the canary 1 (a dword)
 *   2   the canary 2 (a dword)
 *   3   the counter - it changes every tick, it shows which of the copies
 *       of the array in the heap is the live one
 *
 * The canaries sit right behind the value: a freeze that writes more bytes
 * than the type of the frozen value asks for destroys them and the activity
 * reports that in the log of the process.
 *
 * The ticker keeps the value of the buffer: the search of the panel has to
 * find it.  Every five seconds the ticker writes a poison into the value
 * and watches it: a frozen value is written back by the daemon, so the
 * poison does not survive and the activity reports the freeze.
 */
public class FreezeProbeActivity extends Activity {

    public static final String TAG = "GGFreezeProbe";

    /** a random value: it has to show up exactly once in the process */
    public static final int SEED = new Random().nextInt() & 0x7fffffff | 1;
    public static final int POISON = 0xDEADBEEF;
    public static final int CANARY1 = 0xA1A2A3A4;
    public static final int CANARY2 = 0xB1B2B3B4;
    public static final int CANARY3 = 0xC1C2C3B4;
    public static final long MARKER = 0x1122334455667788L;
    public static final float FLOAT1 = 1.25f;
    public static final float FLOAT2 = 2.5f;

    public static volatile int[] words;
    public static volatile long addr = -1;
    public static volatile int ticks;
    public static volatile int freezes;
    public static volatile int corruptions;
    public static volatile boolean poisoned;
    public static volatile long poisonedAt;
    /** "search": the value stays the same, "test": the value is poisoned */
    public static volatile String mode = "search";
    /** the garbage of the mode "churn" */
    public static volatile java.util.ArrayList<byte[]> junk;

    public static TextView text;
    public static Thread ticker;

    public static String hex(long v) {
        return Long.toHexString(v);
    }

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        text = new TextView(this);
        text.setText("GGFreezeProbe");
        setContentView(text);

        words = new int[]{SEED, CANARY1, CANARY2, 0};

        Log.i(TAG, "start seed=" + SEED + " seedhex=" + Integer.toHexString(SEED)
                + " pid=" + android.os.Process.myPid());
        registerMode();
        startTicker();
    }

    /**
     * The mode of the test bed is switched with a broadcast:
     *
     *   am broadcast -a com.gg.freezeprobe.MODE --es mode search
     *   am broadcast -a com.gg.freezeprobe.MODE --es mode test
     */
    private void registerMode() {
        BroadcastReceiver r = new FreezeProbeModeReceiver();
        IntentFilter f = new IntentFilter("com.gg.freezeprobe.MODE");
        registerReceiver(r, f);
    }

    /**
     * The ticker runs on its own thread: the panel of GameGuardian covers
     * the activity and the activity would pause its own handler, which
     * would look like a frozen process in the log of the device.
     */
    static void startTicker() {
        if (ticker != null) {
            return;
        }
        ticker = new Thread(new FreezeProbeTicker(), "gg-freeze-ticker");
        ticker.setDaemon(true);
        ticker.start();
    }
}

/**
 * The receiver is a top level class: the d8 of the build tools 34 trips
 * over the anonymous inner classes of javac.
 */
class FreezeProbeModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent i) {
        String m = i.getStringExtra("mode");
        if (m == null) {
            return;
        }
        FreezeProbeActivity.mode = m;
        FreezeProbeActivity.poisoned = false;
        Log.i(FreezeProbeActivity.TAG, "mode=" + m);
    }
}

class FreezeProbeTicker implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                tick();
            } catch (Throwable t) {
                Log.e(FreezeProbeActivity.TAG, "ticker: " + t);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void tick() {
        FreezeProbeActivity.ticks++;
        int[] w = FreezeProbeActivity.words;
        if (w == null) {
            return;
        }
        if ("test".equals(FreezeProbeActivity.mode)) {
            // the value is poisoned every tick, a frozen value is written
            // back by the daemon and shows up in the read back
            w[0] = FreezeProbeActivity.POISON;
            // The read back has to wait for the daemon: the daemon writes
            // the frozen value every 33 ms and the tick of the ticker runs
            // every 100 ms, so a read back right after the poison only
            // sees the poison and the freeze is never counted.
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                return;
            }
            int t = w[0];
            if (t == FreezeProbeActivity.SEED) {
                FreezeProbeActivity.freezes++;
                Log.i(FreezeProbeActivity.TAG, "FREEZE tick=" + FreezeProbeActivity.ticks
                        + " value=" + Integer.toHexString(t));
            } else if (t != FreezeProbeActivity.POISON) {
                Log.w(FreezeProbeActivity.TAG, "UNEXPECTED value=" + Integer.toHexString(t));
            }
        } else if ("churn".equals(FreezeProbeActivity.mode)) {
            // the garbage collector has to move the array: the frozen
            // address of the panel then points into the heap of another
            // object and the daemon writes into it
            java.util.ArrayList<byte[]> junk = new java.util.ArrayList<byte[]>();
            for (int i = 0; i < 60; i++) {
                byte[] b = new byte[64 * 1024];
                b[0] = (byte) i;
                b[b.length - 1] = (byte) i;
                junk.add(b);
            }
            FreezeProbeActivity.junk = junk;
            System.gc();
            FreezeProbeActivity.junk = null;
            junk.clear();
            Log.i(FreezeProbeActivity.TAG, "churn tick=" + FreezeProbeActivity.ticks);
            w[0] = FreezeProbeActivity.POISON;
        } else if ("clock".equals(FreezeProbeActivity.mode)) {
            // The speed hack of the panel makes the clock of the target run
            // faster.  The value of System.currentTimeMillis() is written
            // to the log every second of the real time; the ratio of the
            // growth of that value to the growth of the real time of the
            // device is the factor of the speed hack.
            if (FreezeProbeActivity.ticks % 10 == 0) {
                // The clock of ART (System.currentTimeMillis) lives in the
                // runtime of the system, the daemon does not hook it.  The
                // clock of SystemClock lives in the library of the
                // framework, that one is hooked: it shows the factor of
                // the speed hack.
                Log.i(FreezeProbeActivity.TAG, "CLOCK virtual=" + System.currentTimeMillis()
                        + " mono=" + System.nanoTime()
                        + " native=" + android.os.SystemClock.uptimeMillis()
                        + " boot=" + android.os.SystemClock.elapsedRealtime()
                        + " ticks=" + FreezeProbeActivity.ticks);
            }
        } else {
            if (w[0] != FreezeProbeActivity.SEED) {
                // the value has to stay the same, the search has to find it
                w[0] = FreezeProbeActivity.SEED;
            }
        }
        // the canaries behind the value
        int c1 = w[1];
        int c2 = w[2];
        if (c1 != FreezeProbeActivity.CANARY1
                || c2 != FreezeProbeActivity.CANARY2
                ) {
            FreezeProbeActivity.corruptions++;
            Log.e(FreezeProbeActivity.TAG, "CORRUPTION c1=" + Integer.toHexString(c1)
                    + " c2=" + Integer.toHexString(c2)
                    );
        }
        // the counter shows the live copy of the array
        w[3]++;
        if (FreezeProbeActivity.ticks % 100 == 0) {
            Log.i(FreezeProbeActivity.TAG, "status ticks=" + FreezeProbeActivity.ticks
                    + " freezes=" + FreezeProbeActivity.freezes
                    + " corrupt=" + FreezeProbeActivity.corruptions
                    + " counter=" + w[3]
                    + " seed=" + FreezeProbeActivity.SEED);
        }
    }
}
