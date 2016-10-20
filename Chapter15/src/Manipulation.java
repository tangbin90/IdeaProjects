/**
 * Created by TangBin on 9/8/16.
 */
class Manipulator<T extends HasF>{
    private T obj;

    public Manipulator(T x) {
        obj=x;
    }

    public void manipulate() {
        obj.f();
    }
}

class HasF{
    public void f() {
        System.out.println("HasF.f()");
    }
}
public class Manipulation {
    public static void main(String... args)
    {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator=new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}
