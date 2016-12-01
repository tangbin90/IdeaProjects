/**
 * Created by TangBin on 14/11/2016.
 */
import static net.mindview.util.Print.*;

class DualSync{
    private Object syncObject = new Object();
    public synchronized void f(){
        for(int i=0; i<5; i++){
            print("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (syncObject){
            for(int i=0;i<5;i++){
                print("g()");
                Thread.yield();
            }
        }
    }
}
public class SyncObject {
    public static void main(String[] args){
        final DualSync ds = new DualSync();
        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();
        ds.g();
    }
}
