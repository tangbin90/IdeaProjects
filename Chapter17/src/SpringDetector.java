/**
 * Created by TangBin on 9/19/16.
 */
import java.lang.reflect.*;
import java.util.*;

public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
        for(int i=0;i<10;i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map = "+map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up predicton for "+ gh);
        if(map.containsKey(gh))
            System.out.print((map.get(gh)));
        else
            System.out.print("Key not found: "+gh);

    }

    public  static void main(String[] args) throws Exception{
        detectSpring(Groundhog.class);
    }
}
