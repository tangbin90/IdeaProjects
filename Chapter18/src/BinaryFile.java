import java.io.IOException;
import java.io.*;
/**
 * Created by TangBin on 14/10/2016.
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try{
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally{
            bf.close();
        }
    }

    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsoluteFile());
    }
}
