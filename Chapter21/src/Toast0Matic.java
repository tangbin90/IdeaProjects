/**
 * Created by TangBin on 22/11/2016.
 */
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;



class Toast{
    public enum  ToastStatus{DRY, BUTTERED, JAMMED}
    private ToastStatus status = ToastStatus.DRY;
    private final int id;
    public Toast(int idn){id = idn;}
    public void butter(){status = ToastStatus.BUTTERED;}
    public void jam(){status = ToastStatus.JAMMED;}
    public ToastStatus getStatus() {
        return status;
    }
    public int getId(){return id;}
    public String toString(){
        return "Toast "+id +":"+status;
    }
}

class ToastQueue extends LinkedBlockingDeque<Toast>{}

class Toaster implements Runnable{
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq){toastQueue = tq;}
    public void run(){
        try{
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(500));
                Toast t = new Toast(count++);
                print(t);

                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            print("Toaster interrupted");
        }
        print("Toast off");
    }
}

class Butterer implements Runnable{
    private ToastQueue dryQueue, butteredQueue;
    public Butterer(ToastQueue dry, ToastQueue buttered){
        dryQueue = dry;
        butteredQueue = buttered;
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                print(t);
                butteredQueue.put(t);
            }
        }catch (InterruptedException e){
            print("BUtterer interrupted");
        }
        print("Butterer off");
    }
}

class Jammer implements Runnable{
    private ToastQueue butteredQueue, finishedQueue;
    public Jammer(ToastQueue buttered, ToastQueue jamed){
        butteredQueue = buttered;
        finishedQueue = jamed;
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = butteredQueue.take();
                t.jam();
                print(t);
                finishedQueue.put(t);
            }
        }catch (InterruptedException e){
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}

class Eater implements Runnable{
    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finished){
        finishedQueue = finished;
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = finishedQueue.take();
                if(t.getId()!=counter++||t.getStatus()!=Toast.ToastStatus.JAMMED){
                    print(">>>> Eorror: "+t);
                    System.exit(1);
                }else
                    print("Chomp! "+t);
            }
        }catch (InterruptedException e){
            print("Eater interrupted");
        }
        print("Eater off");
    }
}

public class Toast0Matic {
    public static void main(String... args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue,butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

