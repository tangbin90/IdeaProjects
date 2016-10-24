package enumerated;

/**
 * Created by TangBin on 24/10/2016.
 */
import java.util.*;
import static enumerated.AlarmPoints.*;
import static net.mindview.util.Print.*;

enum Activity {SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING}

interface Command{void action();}

public class EnumMaps {
    public static void main(String[] args) {
       EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
       em.put(AlarmPoints.KITCHEN, new Command() {
           @Override
           public void action() {
               print("Kitchen fire!");
           }
       });
       em.put(BATHROOM, new Command() {
           @Override
           public void action() {
               print("Bathroom alert!");
           }
       }) ;

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey()+": ");
            e.getValue().action();
        }

        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }

    }
}
