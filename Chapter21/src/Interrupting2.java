/**
 * Created by TangBin on 16/11/2016.
 */

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import static net.mindview.util.Print.*;

class BlockedMutex{
    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        lock.lock();
    }

    public void f(){
        try{
            lock.lockInterruptibly();
            print("lock acquired in f()");
        }catch (InterruptedException e){
            print("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable{
    BlockedMutex blocked = new BlockedMutex();
    public void run(){
        print("Waiting for f() in bLockedMutex");
        blocked.f();
        print("Bronken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}
