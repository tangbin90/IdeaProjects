/**
 * Created by TangBin on 21/10/2016.
 */
enum Search{HITHER, YON}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }

}
