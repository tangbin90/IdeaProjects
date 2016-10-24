import java.io.ObjectInputStream;

/**
 * Created by TangBin on 21/10/2016.
 */
import java.lang.*;

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try{
            for(Object en : intClass.getEnumConstants())
                System.out.println(en);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
