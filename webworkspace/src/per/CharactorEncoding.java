package per;

/**
 * Created by TangBin on 13/12/2016.
 */
import java.io.UnsupportedEncodingException;

public class CharactorEncoding {
    public CharactorEncoding(){}
    public String toString(String str) {
        String text="";
        if(str!=null&&!"".equals(str)){
            try{
                text = new String(str.getBytes("ISO-8859-1"),"UTF-8");
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        return text;
    }
}
