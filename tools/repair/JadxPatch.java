import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Patches jadx 1.5.6 so that it can decompile the four GameGuardian methods
 * that are too large for its control flow recovery and type inference.
 *
 *   1. BlockProcessor.checkForUnreachableBlocks() aborts a method when a basic
 *      block has no predecessor.  For android.ext.m.e() that is a single dead
 *      block, so it is dropped from the block list instead of losing the body.
 *   2. DominatorTree.sortBlocks() aborts for the same reason, the abort is
 *      removed.
 *   3. TypeInferenceVisitor / FixTypesVisitor do not converge on the huge
 *      methods: the type update queue grows until the heap is exhausted.  The
 *      propagation is disabled, the raw dex types are used instead.
 *
 * Usage: java -cp asm.jar JadxPatch <jadx-all.jar> <out-dir>
 */
public class JadxPatch {

    public static void main(String[] args) throws Exception {
        Path jar = Paths.get(args[0]);
        Path out = Paths.get(args[1]);
        Files.createDirectories(out);
        patchBlockProcessor(jar, out);
        patchDominatorTree(jar, out);
        String skipAbove = System.getProperty("jadxpatch.skipTypeAbove", "3000");
        int limit = Integer.parseInt(skipAbove);
        patchTypeInference(jar, out, limit);
        patchFixTypes(jar, out, limit);
        String typeLimit = System.getProperty("jadxpatch.typeLimit");
        if (typeLimit != null) {
            patchTypeUpdateLimit(jar, out, Integer.parseInt(typeLimit));
        }
        System.out.println("patched classes written to " + out);
    }

    static byte[] read(Path jar, String entry) throws IOException {
        try (ZipFile zf = new ZipFile(jar.toFile())) {
            ZipEntry e = zf.getEntry(entry);
            if (e == null) {
                throw new IOException("missing " + entry);
            }
            try (InputStream in = zf.getInputStream(e)) {
                return in.readAllBytes();
            }
        }
    }

    static void write(Path out, String entry, byte[] data) throws IOException {
        Path p = out.resolve(entry);
        Files.createDirectories(p.getParent());
        Files.write(p, data);
    }

    static ClassWriter writer(ClassReader cr) {
        /* keep the original constant pool, frames and max locals */
        return new ClassWriter(cr, 0);
    }

    /** Recomputes the stack map frames, needed when a branch is inserted. */
    static ClassWriter writerFrames(ClassReader cr) {
        return new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES) {
            @Override
            protected String getCommonSuperClass(String a, String b) {
                try {
                    return super.getCommonSuperClass(a, b);
                } catch (Throwable t) {
                    return "java/lang/Object";
                }
            }
        };
    }

    /** Inserts "if (mth.getInsnsCount() > limit) return false;" at the start. */
    static MethodVisitor skipBigMethods(MethodVisitor mv, int limit) {
        return new MethodVisitor(Opcodes.ASM9, mv) {
            @Override
            public void visitCode() {
                super.visitCode();
                Label skip = new Label();
                super.visitVarInsn(Opcodes.ALOAD, 1);
                super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "jadx/core/dex/nodes/MethodNode",
                        "getInsnsCount", "()I", false);
                super.visitLdcInsn(limit);
                super.visitJumpInsn(Opcodes.IF_ICMPLE, skip);
                super.visitInsn(Opcodes.ICONST_0);
                super.visitInsn(Opcodes.IRETURN);
                super.visitLabel(skip);
            }
        };
    }

    /**
     * Replaces the body of a method with a plain return (false for boolean
     * methods).  The original instructions, labels and frames are dropped.
     */
    static MethodVisitor killBody(final MethodVisitor mv, final boolean booleanResult) {
        return new MethodVisitor(Opcodes.ASM9, mv) {
            boolean done;

            @Override
            public void visitCode() {
                super.visitCode();
                if (booleanResult) {
                    super.visitInsn(Opcodes.ICONST_0);
                    super.visitInsn(Opcodes.IRETURN);
                } else {
                    super.visitInsn(Opcodes.RETURN);
                }
                done = true;
            }

            @Override
            public void visitInsn(int opcode) {
                if (!done) {
                    super.visitInsn(opcode);
                }
            }

            @Override
            public void visitIntInsn(int opcode, int operand) {
                if (!done) {
                    super.visitIntInsn(opcode, operand);
                }
            }

            @Override
            public void visitVarInsn(int opcode, int varIndex) {
                if (!done) {
                    super.visitVarInsn(opcode, varIndex);
                }
            }

            @Override
            public void visitTypeInsn(int opcode, String type) {
                if (!done) {
                    super.visitTypeInsn(opcode, type);
                }
            }

            @Override
            public void visitFieldInsn(int opcode, String owner, String name, String desc) {
                if (!done) {
                    super.visitFieldInsn(opcode, owner, name, desc);
                }
            }

            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                if (!done) {
                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                }
            }

            @Override
            public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
                if (!done) {
                    super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
                }
            }

            @Override
            public void visitJumpInsn(int opcode, Label label) {
                if (!done) {
                    super.visitJumpInsn(opcode, label);
                }
            }

            @Override
            public void visitLabel(Label label) {
                if (!done) {
                    super.visitLabel(label);
                }
            }

            @Override
            public void visitLdcInsn(Object value) {
                if (!done) {
                    super.visitLdcInsn(value);
                }
            }

            @Override
            public void visitIincInsn(int varIndex, int increment) {
                if (!done) {
                    super.visitIincInsn(varIndex, increment);
                }
            }

            @Override
            public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
                if (!done) {
                    super.visitTableSwitchInsn(min, max, dflt, labels);
                }
            }

            @Override
            public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
                if (!done) {
                    super.visitLookupSwitchInsn(dflt, keys, labels);
                }
            }

            @Override
            public void visitMultiANewArrayInsn(String desc, int numDimensions) {
                if (!done) {
                    super.visitMultiANewArrayInsn(desc, numDimensions);
                }
            }

            @Override
            public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
                if (!done) {
                    super.visitTryCatchBlock(start, end, handler, type);
                }
            }

            @Override
            public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
                if (!done) {
                    super.visitFrame(type, numLocal, local, numStack, stack);
                }
            }

            @Override
            public void visitLineNumber(int line, Label start) {
                if (!done) {
                    super.visitLineNumber(line, start);
                }
            }
        };
    }

    /** Downgrades addError(String,Throwable) to addWarnComment(String,Throwable). */
    static MethodVisitor warnInsteadOfError(MethodVisitor mv) {
        return new MethodVisitor(Opcodes.ASM9, mv) {
            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                if (opcode == Opcodes.INVOKEVIRTUAL && name.equals("addError")
                        && desc.equals("(Ljava/lang/String;Ljava/lang/Throwable;)V")) {
                    super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, owner, "addWarnComment", desc, itf);
                    return;
                }
                super.visitMethodInsn(opcode, owner, name, desc, itf);
            }
        };
    }

    /**
     * Drop the dead basic block instead of aborting the whole method.
     */
    static void patchBlockProcessor(Path jar, Path out) throws Exception {
        String entry = "jadx/core/dex/visitors/blocks/BlockProcessor.class";
        ClassReader cr = new ClassReader(read(jar, entry));
        ClassWriter cw = writer(cr);
        cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex);
                if (!name.equals("checkForUnreachableBlocks")) {
                    return mv;
                }
                return new MethodVisitor(Opcodes.ASM9, mv) {
                    boolean inThrow;

                    @Override
                    public void visitTypeInsn(int opcode, String type) {
                        if (opcode == Opcodes.NEW
                                && type.equals("jadx/core/utils/exceptions/JadxRuntimeException")) {
                            /* local 2 holds the iterator over the block list */
                            super.visitVarInsn(Opcodes.ALOAD, 2);
                            super.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/Iterator",
                                    "remove", "()V", true);
                            inThrow = true;
                            return;
                        }
                        super.visitTypeInsn(opcode, type);
                    }

                    @Override
                    public void visitInsn(int opcode) {
                        if (inThrow && (opcode == Opcodes.DUP || opcode == Opcodes.ATHROW)) {
                            if (opcode == Opcodes.ATHROW) {
                                inThrow = false;
                            }
                            return;
                        }
                        super.visitInsn(opcode);
                    }

                    @Override
                    public void visitVarInsn(int opcode, int varIndex) {
                        if (inThrow) {
                            return;
                        }
                        super.visitVarInsn(opcode, varIndex);
                    }

                    @Override
                    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
                        if (inThrow) {
                            return;
                        }
                        super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
                    }

                    @Override
                    public void visitLdcInsn(Object value) {
                        if (inThrow) {
                            return;
                        }
                        super.visitLdcInsn(value);
                    }

                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                        if (inThrow) {
                            /* String.valueOf + concat + <init> + athrow belong
                             * to the dropped exception */
                            return;
                        }
                        super.visitMethodInsn(opcode, owner, name, desc, itf);
                    }
                };
            }
        }, 0);
        write(out, entry, cw.toByteArray());
        System.out.println("patched " + entry);
    }

    /** Do not abort the dominator tree computation on unreachable blocks. */
    static void patchDominatorTree(Path jar, Path out) throws Exception {
        String entry = "jadx/core/dex/visitors/blocks/DominatorTree.class";
        ClassReader cr = new ClassReader(read(jar, entry));
        ClassWriter cw = writer(cr);
        cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex);
                if (!name.equals("sortBlocks")
                        || !desc.equals("(Ljadx/core/dex/nodes/MethodNode;)Ljava/util/List;")) {
                    return mv;
                }
                return new MethodVisitor(Opcodes.ASM9, mv) {
                    boolean inThrow;

                    @Override
                    public void visitTypeInsn(int opcode, String type) {
                        if (opcode == Opcodes.NEW
                                && type.equals("jadx/core/utils/exceptions/JadxRuntimeException")) {
                            inThrow = true;
                            return;
                        }
                        super.visitTypeInsn(opcode, type);
                    }

                    @Override
                    public void visitInsn(int opcode) {
                        if (inThrow && (opcode == Opcodes.DUP || opcode == Opcodes.ATHROW)) {
                            if (opcode == Opcodes.ATHROW) {
                                inThrow = false;
                            }
                            return;
                        }
                        super.visitInsn(opcode);
                    }

                    @Override
                    public void visitLdcInsn(Object value) {
                        if (inThrow) {
                            return;
                        }
                        super.visitLdcInsn(value);
                    }

                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                        if (inThrow) {
                            return;
                        }
                        super.visitMethodInsn(opcode, owner, name, desc, itf);
                    }
                };
            }
        }, 0);
        write(out, entry, cw.toByteArray());
        System.out.println("patched " + entry);
    }

    /**
     * TypeInferenceVisitor: the propagation loop does not converge on the huge
     * GameGuardian methods, it is replaced by "nothing to propagate".
     */
    static void patchTypeInference(Path jar, Path out, int limit) throws Exception {
        String entry = "jadx/core/dex/visitors/typeinference/TypeInferenceVisitor.class";
        ClassReader cr = new ClassReader(read(jar, entry));
        ClassWriter cw = writerFrames(cr);
        cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex);
                if (name.equals("runTypePropagation")
                        && desc.equals("(Ljadx/core/dex/nodes/MethodNode;)Z")) {
                    return skipBigMethods(mv, limit);
                }
                return warnInsteadOfError(mv);
            }
        }, 0);
        write(out, entry, cw.toByteArray());
        System.out.println("patched " + entry);
    }

    /**
     * FixTypesVisitor: the type deduction loop does not converge either.
     */
    static void patchFixTypes(Path jar, Path out, int limit) throws Exception {
        String entry = "jadx/core/dex/visitors/typeinference/FixTypesVisitor.class";
        ClassReader cr = new ClassReader(read(jar, entry));
        ClassWriter cw = writerFrames(cr);
        cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String ex2[]) {
                MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex2);
                if (name.equals("deduceType") && desc.startsWith("(Ljadx/core/dex/nodes/MethodNode;")) {
                    return skipBigMethods(mv, limit);
                }
                if (name.equals("runMultiVariableSearch")
                        && desc.equals("(Ljadx/core/dex/nodes/MethodNode;)Z")) {
                    return skipBigMethods(mv, limit);
                }
                return warnInsteadOfError(mv);
            }
        }, 0);
        write(out, entry, cw.toByteArray());
        System.out.println("patched " + entry);
    }

    /** Optional: replace the type update limit with a fixed value. */
    static void patchTypeUpdateLimit(Path jar, Path out, int limit) throws Exception {
        String entry = "jadx/core/dex/visitors/typeinference/TypeUpdateInfo.class";
        ClassReader cr = new ClassReader(read(jar, entry));
        ClassWriter cw = writer(cr);
        cr.accept(new ClassVisitor(Opcodes.ASM9, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex);
                if (!name.equals("requestUpdate")) {
                    return mv;
                }
                return new MethodVisitor(Opcodes.ASM9, mv) {
                    @Override
                    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
                        if (opcode == Opcodes.GETFIELD && name.equals("updatesLimitCount")) {
                            super.visitInsn(Opcodes.POP);
                            super.visitLdcInsn(limit);
                            return;
                        }
                        super.visitFieldInsn(opcode, owner, name, desc);
                    }
                };
            }
        }, 0);
        write(out, entry, cw.toByteArray());
       System.out.println("patched " + entry + " (limit=" + limit + ")");
   }
}
