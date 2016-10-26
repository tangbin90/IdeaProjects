package enumerated;

/**
 * Created by TangBin on 25/10/2016.
 */
import java.util.*;
import static enumerated.Outcome.*;



interface Item{
        Outcome compete(Item it);
        Outcome eval(Paper p);
        Outcome eval(Scissors s);
        Outcome eval(Rock r);
        }

class Paper implements Item{
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    public Outcome eval(Paper paper) {
        return DRAW;
    }

    public Outcome eval(Rock rock) {
        return WIN;
    }

    public Outcome eval(Scissors scissors) {
        return LOSE;
    }

    public String toString() {
        return "Paper";
    }
}
class Scissors implements Item {
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    public Outcome eval(Paper paper) {
        return LOSE;
    }

    public Outcome eval(Rock rock) {
        return WIN;
    }

    public Outcome eval(Scissors scissors) {
        return DRAW;
    }

    public String toString() {
        return "Scissors";
    }

}

class Rock implements Item {
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    public Outcome eval(Paper paper) {
        return WIN;
    }

    public Outcome eval(Rock rock) {
        return DRAW;
    }

    public Outcome eval(Scissors scissors) {
        return LOSE;
    }

    public String toString(){
        return "Rock";
    }
}

public class RoShamBo1{
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)){
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(a+" vs. "+b+": "+a.compete(b));
    }

    public static void main(String[] args) {
        for(int i=0;i<SIZE;i++)
            match(newItem(), newItem());
    }
}


