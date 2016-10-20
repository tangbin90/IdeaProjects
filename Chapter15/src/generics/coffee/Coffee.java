/**
 * Created by TangBin on 9/6/16.
 */
package generics.coffee;
import java.util.*;
public class Coffee {
    private static long counter=0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }
}
