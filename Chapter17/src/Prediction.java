/**
 * Created by TangBin on 9/19/16.
 */
import java.lang.reflect.*;
import java.util.*;
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble()>0.5;
    public String toString(){
        if(shadow)
            return "Winter is coming";
        else
            return "Early Spring!";
    }
}


