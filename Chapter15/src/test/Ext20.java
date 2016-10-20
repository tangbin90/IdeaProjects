package test;

/**
 * Created by TangBin on 9/8/16.
 */
interface simple{
    void method1();
    void method2();
}
public class Ext20 implements simple{
    public void method1() {
        System.out.println("Ext20" + " method1");
    }

    public void method2() {
        System.out.println("Ext20" + " method12");
    }

    public void method3() {
        System.out.println("Ext20"+"method3");
    }

    public static void main(String... args)
    {
        anewclass a=new anewclass();
        Ext20 ex=new Ext20();
        a.amethod(ex);
    }
}

class anewclass{
    public <T extends simple> void amethod(T x){
        x.method1();
        x.method2();
    }
}
