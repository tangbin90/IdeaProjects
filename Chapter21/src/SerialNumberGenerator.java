/**
 * Created by TangBin on 13/11/2016.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNUmber(){
        return serialNumber++;
    }
}
