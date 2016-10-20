/**
 * Created by TangBin on 12/10/2016.
 */
import java.io.*;

public class MemoryInput {
    public static void main(String[] args)throws IOException{
        StringReader in = new StringReader(BufferedInputFile.read("./src/MemoryInput.java"));
        int c;
        while((c=in.read())!=-1)
            System.out.print((char)c);
    }
}
