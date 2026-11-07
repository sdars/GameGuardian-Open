import sys,struct
sys.path.insert(0,'/root/gameguardian/tools')
import adlib
def su(cmd):
    q=cmd.replace("'","'\\''")
    return adlib.adb('shell',"su -c '%s'"%q,timeout=180).stdout
def mem(pid,addr,size):
    out=su('dd if=/proc/%s/mem bs=1 skip=%d count=%d 2>/dev/null | od -A n -v -t x1'%(pid,addr,size))
    hexs=out.split()
    if len(hexs)<size:
        return None
    return bytes(int(x,16) for x in hexs)
pid=sys.argv[1]
out=su('cat /proc/%s/maps'%pid)
libs=[l for l in out.splitlines() if 'lib6.so' in l]
if not libs:
    print('no lib6 in the target'); raise SystemExit
base=min(int(l.split('-')[0],16) for l in libs)
TABLE=0x25f80
tab=mem(pid,base+TABLE,16*8)
if tab is None:
    print('no table'); raise SystemExit
for i in range(16):
    obj=struct.unpack('<Q',tab[i*8:i*8+8])[0]
    if obj==0: continue
    d=mem(pid,obj,0x40)
    if d is None:
        print('slot %2d obj=%#x unreadable'%(i,obj))
        continue
    num,den=struct.unpack('<ii',d[0x08:0x10])
    flag=d[0x18]
    last=struct.unpack('<q',d[0x20:0x28])[0]
    b2=struct.unpack('<q',d[0x28:0x30])[0]
    acc=struct.unpack('<q',d[0x30:0x38])[0]
    index=struct.unpack('<i',d[0x38:0x3c])[0]
    print('slot %2d obj=%#x flag=%d index=%3d num=%d den=%d base=%.3f acc=%d last=%.3f'%(i,obj,flag,index,num,den,b2/1e9,acc,last/1e9))
