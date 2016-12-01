/**
 * Created by TangBin on 30/11/2016.
 */
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class FastSumulation {
    static final int N_ELEMENTs = 100000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS=50;

    static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTs][N_GENES];
    static Random rand = new Random(47);
    static class Evolver implements  Runnable{
        public void run(){
            while(!Thread.interrupted()){
                int element = rand.nextInt(N_ELEMENTs);
                for(int i=0;i<N_GENES;i++){
                    int previous = element-1;
                    if(previous<0) previous = N_ELEMENTs-1;
                    int next = element+1;
                    if(next>=N_ELEMENTs) next = 0;
                    int oldvalue = GRID[element][i].get();
                    int newvalue = oldvalue+GRID[previous][i].get()+GRID[next][i].get();
                    newvalue /=3;
                    if(!GRID[element][i].compareAndSet(oldvalue,newvalue)){
                        print("Old value changed from "+oldvalue);
                    }
                }
                int previous = element -1;

            }
        }
    }

    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<N_ELEMENTs;i++)
            for(int j=0;j<N_GENES;j++)
                GRID[i][j] = new AtomicInteger(rand.nextInt(1000));

        for(int i=0;i<N_EVOLVERS;i++)
            exec.execute(new Evolver());
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
