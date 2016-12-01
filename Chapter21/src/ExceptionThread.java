/**
 * Created by TangBin on 09/11/2016.
 */
import java.util.concurrent.*;

public class ExceptionThread implements Runnable{
    public void run(){
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
