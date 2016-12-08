/**
 * Created by TangBin on 06/12/2016.
 */
import net.mindview.util.TaskItem;
import java.util.concurrent.*;
import java.util.*;
import java.util.List;

public class TaskManager<R, C extends Callable<R>> extends ArrayList{
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    public void add(C task){
        add(new TaskItem<R, C>(exec.submit(task),task));
    }

    public List<R> getResults() {
        Iterator<TaskItem<R, C>> items = iterator();
        List<R> results = new ArrayList<R>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (item.future.isDone()) {
                try{
                    results.add(item.future.get());
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                items.remove();
            }
        }
        return results;
    }

    public List<String> purge(){
        Iterator<TaskItem<R,C>> items = iterator();
        List<String> results = new ArrayList<String>();
        while(items.hasNext()){
            TaskItem<R, C> item = items.next();
            if(!item.future.isDone()){
                results.add("Cancellng "+item.task);
                item.future.cancel(true);
                items.remove();
            }
        }
        return results;
    }
}