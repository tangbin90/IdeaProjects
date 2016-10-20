/**
 * Created by TangBin on 9/19/16.
 */
//Thins you can do with Maps
import java.util.*;
public class Maps {
    public static void printKeys(Map<Integer, String> map){
        System.out.println("Size= "+map.size()+", ");
        System.out.println("Keys: ");
        System.out.print(map.keySet());
    }

    public static void test(Map<Integer, String> map){
        System.out.print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printKeys(map);

        System.out.print("Values: ");
        System.out.println(map.values());
    }

    public static void main(String[] args){
        test(new HashMap<Integer,String>());
        test(new TreeMap<Integer,String>());
    }
}
