/**
 * Created by TangBin on 09/11/2016.
 */
import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.*;

class ExceptionThread2 implements Runnable{
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("run() by"+t);
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncautExceptionhandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t, Throwable e){
        System.out.println("caught" + e);
    }
}

class HandlerThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable r){
        System.out.println(this+" creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncautExceptionhandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
}


public class CaptureUncaughtException{
    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncautExceptionhandler());
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}


