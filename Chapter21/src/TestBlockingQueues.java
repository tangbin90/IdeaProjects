/**
 * Created by TangBin on 21/11/2016.
 */
import java.util.concurrent.*;
import java.io.*;
import static net.mindview.util.Print.*;

class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        rockets = queue;
    }

    public void add(LiftOff lo){
        try{
            rockets.put(lo);
        }catch (InterruptedException e){
            print("Interrypted during put()");
        }
    }

    public void run(){
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();//运行队列中的任务
            }
        } catch (InterruptedException e) {
            print("Waking from take()");
        }

        print("Exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {
    static void getkey(){
        try{
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (java.io.IOException e){
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message){
        print(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue){
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i=0;i<5;i++)
            runner.add(new LiftOff(5));
        getkey("Press 'Enter' ("+ msg +")");
        t.interrupt();
        print("Finished "+msg +" test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }
}
