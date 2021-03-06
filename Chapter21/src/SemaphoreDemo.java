/**
 * Created by TangBin on 23/11/2016.
 */

import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class CheckoutTask<T> implements  Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool){
        this.pool = pool;
    }

    public void run(){
        try{
            T item = pool.checkOut();
            print(this + "checked out "+item);
            TimeUnit.SECONDS.sleep(1);
            print(this+" checking in "+item);
            pool.checkIn(item);
        }catch (InterruptedException e){

        }
    }
    public String toString(){
        return "ChecloutTask "+id+" ";
    }
}
public class SemaphoreDemo {
    final static int SIZE=25;
    public static void main(String[] args)throws Exception{
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<SIZE;i++)
            exec.execute(new CheckoutTask<Fat>(pool));
        print("All CheckedoutTasks created");
        List<Fat> list = new ArrayList<Fat>();
        for(int i=0;i<SIZE;i++){
            Fat f = pool.checkOut();
            printnb(i+": main() thread checked out");
            f.operation();
            list.add(f);
        }
        Future<?> blocked = exec.submit(new Runnable() {
            public void run(){
                try{
                    print("prepare to block");
                    pool.checkOut();
                    print("cant check out!!!!!");
                }catch (InterruptedException e){
                    print("checkOut() Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        print("Checking in objects in "+list);
        for(Fat f: list)
            pool.checkIn(f);
        for(Fat f:list)
            pool.checkIn(f);
        exec.shutdown();
    }
}
