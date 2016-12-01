/**
 * Created by TangBin on 16/11/2016.
 */

import java.util.concurrent.*;
import java.io.*;
import static net.mindview.util.Print.*;

class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException exception) {
            print("InterruptedException");
        }
        print("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable{
    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    public void run(){
        try{
            print("Waiting for read():");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted()){
                print("Interrupted from blocked I/O");
            }else{
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked,run()");
    }
}

class SynchronizedBlocked implements Runnable{
    public synchronized void f(){
        while(true)
            Thread.yield();
    }

    public SynchronizedBlocked(){
        new Thread(){
            public void run(){
                f();
            }
        }.start();
    }

    public void run(){
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run()");
    }

}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r)throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        print("Interrupting"+r.getClass().getName());
        f.cancel(true);
        print("Interrupt sent to "+r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0);
    }
}
