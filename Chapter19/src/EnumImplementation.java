/**
 * Created by TangBin on 21/10/2016.
 */
import java.util.*;
import net.mindview.util.*;

import static net.mindview.util.Print.*;

interface Generator<T> { T next(); } ///:~

enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY, SPANY, PUBCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);
    public CartoonCharacter next(){
        return values()[rand.nextInt(values().length)];
    }
}
public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ",");
    }
    public static void main(String... args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i=0;i<10;i++)
            printNext(cc);
    }
}
