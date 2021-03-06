package annotations;
import java.lang.reflect.*;
import java.util.*;
import net.mindview.util.*;
/**
 * Created by TangBin on 26/10/2016.
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);//返回指定类型的注解对象
            if (uc != null) {
                System.out.println("Found Use Case: "+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i:useCases){
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, passwordUtils.class);
    }
}
