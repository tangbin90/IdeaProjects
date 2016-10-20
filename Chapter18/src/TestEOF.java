/**
 * Created by TangBin on 12/10/2016.
 */
import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("./src/TestEOF.java")
                )
        );

        while(in.available()!=0)
            System.out.print((char)in.readByte());
    }
}
