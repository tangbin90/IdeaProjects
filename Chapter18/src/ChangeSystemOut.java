/**
 * Created by TangBin on 14/10/2016.
 */
import java.io.*;

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello world");
    }
}
