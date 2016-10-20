/**
 * Created by TangBin on 9/12/16.
 */
import generics.coffee.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.*;

interface Addable<T> { void add(T t);}

public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size)
    {
        for(int i=0;i<size;i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size)
    {
        for(int i=0; i<size;i++)
        {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T>{
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c){
        this.c=c;
    }

    public void add(T item){c.add(item);}
}

class Adapter{
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue implements Addable<T>{
}

class Fill2Test{
    public static void main(String[] args){
        List<Coffee> carrier = new ArrayList<Coffee>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Breve.class, 2);
        for(Coffee c: carrier)
        {
            System.out.println(c);
        }
        System.out.println("--------------------------------");
        AddableSimpleQueue<Coffee> coffeeQueue= new AddableSimpleQueue<Coffee>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Breve.class, 1);
        for(Object c: coffeeQueue)
        {
            System.out.println((Coffee)c);
        }
    }
}

