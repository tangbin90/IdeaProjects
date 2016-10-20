import java.io.IOException;
import java.io.*;
/**
 * Created by TangBin on 12/10/2016.
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException{
        BufferedReader in= new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s=in.readLine())!=null)
            sb.append(s+"\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("BufferedInputFile.class"));
    }
}
