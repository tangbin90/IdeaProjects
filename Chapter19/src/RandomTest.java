/**
 * Created by TangBin on 21/10/2016.
 */
import net.mindview.util.*;

enum Activity {SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING}

public class RandomTest {
    public static void main(String[] args) {
        for(int i=0;i<20;i++) {
            System.out.print(Enums.random(Activity.class));
        }
    }
}
