package annotations;

/**
 * Created by TangBin on 30/10/2016.
 */
import annotations.atunit.*;
import net.mindview.util.*;

public class AtUnitExample1 {
    public String methodOne(){
        return "This is methodOne";
    }

    public int methodTwo(){
        System.out.println("This is MethodTwo");
        return 2;
    }

    @Test boolean methodOneTest(){
        return methodOne().equals("This is methodOne");
    }

    @Test boolean m2(){
        return methodTwo()==2;
    }

    @Test private boolean m3(){return true;}

    @Test boolean failureTest(){return false;}
    @Test boolean anotherDisappiontment(){return false;}
    public static void main(String[] args) throws Exception{
        OSExecute.command("java src.annotations.atunit.Atunit AtUnitExample1");
    }
}
