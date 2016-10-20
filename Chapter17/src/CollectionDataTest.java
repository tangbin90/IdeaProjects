import com.sun.tools.javac.jvm.ClassWriter;

import java.util.LinkedHashMap;
import java.util.*;
/**
 * Created by TangBin on 9/18/16.
 */

class Government implements Generator<String>{
    String[] foundation=("strange women lying in ponds "+"distributing swords is no basis for a system of "+"government").split(" ");
    private int index;
    public String next(){
        return foundation[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args){
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(),15));//保持插入顺序的链接列表
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
