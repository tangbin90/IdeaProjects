import java.util.concurrent.*;

/**
 * Created by TangBin on 01/11/2016.
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"(" + (countDown>0?countDown:"LIftoff!")+"), ";
    }

    public void run(){
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                //Thread.yield();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch(InterruptedException e)
        {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
