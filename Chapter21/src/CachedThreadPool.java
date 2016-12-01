/**
 * Created by TangBin on 01/11/2016.
 */
import java.util.concurrent.*;
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
