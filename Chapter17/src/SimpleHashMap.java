/**
 * Created by TangBin on 9/19/16.
 */
import sun.awt.image.ImageWatched;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    static final int SIZE = 997;
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value){
        V oldvalue=null;
        int index = Math.abs(key.hashCode())%SIZE;
        LinkedList<MapEntry<K,V>> bucket= buckets[index];
        MapEntry<K,V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while(it.hasNext())
        {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldvalue = iPair.getValue();
                it.set(pair);
                found=true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
        return oldvalue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null) return null;
        for(MapEntry<K,V> iPair:buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket: buckets){
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair:bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args){
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
