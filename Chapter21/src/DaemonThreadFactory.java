/**
 * Created by TangBin on 02/11/2016.
 */
import java.util.concurrent.*;

public class DaemonThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.setDaemon(true);
        return t;
    }

}
