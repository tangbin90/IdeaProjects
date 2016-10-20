/**
 * Created by TangBin on 18/10/2016.
 */
import java.nio.*;

public class IntBufferDemo {
    private static final int BSIZE=1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib =  bb.asIntBuffer();

        ib.put(new int[]{121,3,12,31,4,234,3,5,3,5,3,45,43,6});
        System.out.println(ib.get(3));
        ib.put(3, 123);
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
