/**
 * Created by TangBin on 9/19/16.
 */
import java.util.*;

public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<T>();
    public void addFirst(T e){deque.addFirst(e);}
    public void addLast(T e){deque.addLast(e);}
    public T getFirst(T e){return deque.getFirst();}
    public T getLast(T e){return deque.getLast();}
    public T removeFirst(){return deque.removeFirst();}
    public T removeLast(){return deque.removeLast();}
    public int size(){return deque.size();}
    public String toString(){return deque.toString();}
    public LinkedList<Integer> a=new LinkedList();

}
