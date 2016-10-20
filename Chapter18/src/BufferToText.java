/**
 * Created by TangBin on 18/10/2016.
 */
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;

public class BufferToText {
    private static  final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc=new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        //not working
        System.out.println(buff.asCharBuffer());
        //Decode using this system's default charset
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using "+encoding+": "+Charset.forName(encoding).decode(buff));

        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        //use a charbuffer to write through
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("some text");
        fc.write(buff);
        fc.close();
        //Reading and display
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        buff.flip();
        System.out.println(buff.asCharBuffer());



    }
}
