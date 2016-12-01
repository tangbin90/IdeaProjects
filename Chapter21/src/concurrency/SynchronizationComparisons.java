package concurrency;

/**
 * Created by TangBin on 29/11/2016.
 */
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;
import static net.mindview.util.Print.*;

abstract class Accumulator{
public static long cycles = 50000L;
    private static final int N=4;
    public static ExecutorService exec = Executors.newFixedThreadPool(N*2);
    private static CyclicBarrier barrier = new CyclicBarrier(N*2+1);
    protected volatile int index = 0;
    protected volatile int value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 100000;
    protected static int[] preLoaded = new int[SIZE];
    static{
        Random rand = new Random(47);
        for(int i=0;i<SIZE; i++)
            preLoaded[i] = rand.nextInt();
    }

    public abstract void accumulate();
    public abstract long read();
    private class Modifier implements Runnable{
        public void run(){
            for(long i = 0;i<cycles;i++)
                accumulate();
            try{
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable{
        private volatile long value;
        public void run(){
            for(long i = 0; i<cycles;i++)
                value = read();
            try{
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public void timedTest(){
        long start = System.nanoTime();
        for(int i=0;i<N;i++){
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try{
            barrier.await();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        duration = System.nanoTime()-start;
        printf("%-13s: %13d\n", id, duration);
    }
    public static void report(Accumulator acc1, Accumulator acc2){
        printf("%-22s:%.2f\n", acc1.id+"/"+acc2.id, (double)acc1.duration/(double)acc2.duration);
    }
}

class BaseLine extends Accumulator{
    {id = "BaseLine";}
    public void accumulate(){
        int early = index++;  // early add and assign to a temp.
        if(early >= SIZE) {
            index = 0;
            early = 0;
        }
        value += preLoaded[early];
    }

    public long read(){return value;}
}

class SynchronizedTest extends Accumulator{
    {id = "synchronized";}
    public synchronized void accumulate(){
        value += preLoaded[index++];
        if(index>=SIZE) index = 0;
    }

    public synchronized long read(){
        return value;
    }
}

class LockTest extends Accumulator{
    {id = "Lock";}
    private Lock lock = new ReentrantLock();
    public void accumulate(){
        lock.lock();
        try{
            value +=preLoaded[index++];
            if(index>=SIZE) index = 0;
        }finally
        {
            lock.unlock();
        }
    }
    public long read(){
        lock.lock();
        try{
            return value;
        }finally {
            lock.unlock();
        }
    }
}

class AtomicTest extends Accumulator{
    {id = "Atomic";}
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);
    public void accumulate(){
        int early = index.getAndIncrement();
        if(early >= SIZE) {
            index.set(0);
            early = 0;
        }
        value.getAndAdd(preLoaded[early]);
    }
    public long read(){
        return value.get();
    }
}

public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synch=new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();
    static void test(){
        print("=======================================");
        printf("%-12s : %13d\n", "Cycles", Accumulator.cycles);
        baseLine.timedTest();
        synch.timedTest();
        lock.timedTest();
        atomic.timedTest();
        Accumulator.report(synch, baseLine);
        Accumulator.report(lock, baseLine);
        Accumulator.report(atomic, baseLine);
        Accumulator.report(synch,lock);
        Accumulator.report(synch, atomic);
        Accumulator.report(lock, atomic);
    }

    public static void main(String[] args){
        int iterations = 5;
        if(args.length>0)
            iterations = new Integer(args[0]);
        print("Warmup");
        baseLine.timedTest();
        for(int i=0;i<iterations;i++){
            test();
            Accumulator.cycles*=2;
        }
        Accumulator.exec.shutdown();
    }
}
