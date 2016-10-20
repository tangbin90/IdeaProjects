/**
 * Created by TangBin on 9/18/16.
 */
import java.util.*;

class StringAddress{
    private String s;
    public StringAddress(String s){this.s = s;}
    public String toString(){
        return super.toString()+" "+s;
    }
}
public class FillingLists    {
    public static void main(String[] args){
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("World!"));//只可以替换已经存在的元素而不能添加新元素
        System.out.println(list);
    }
}
