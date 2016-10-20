import generics.coffee.GeneratorInterface;

/**
 * Created by TangBin on 9/7/16.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args){
        GeneratorInterface<CountedObject> gen =
                BasicGenerator.create(CountedObject.class);
        for(int i=0;i<5;i++)
            System.out.println(gen.next());
    }
}

