/**
 * Created by TangBin on 10/11/2016.
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
