/**
 * Created by TangBin on 12/10/2016.
 */
import java.io.*;

public class FormattedMemoryInput {

 public static void main(String[] args) throws IOException
 {
     try {
         DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("./src/FormattedMemoryInput.java").getBytes()));
         while (true)
             System.out.print((char) in.readByte());
     } catch (EOFException e) {
         System.err.println("End of stream");
     }
 }

 }

