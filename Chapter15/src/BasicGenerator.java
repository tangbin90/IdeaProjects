import generics.coffee.*;
/**
 * Created by TangBin on 9/7/16.
 */
public class BasicGenerator<T> implements GeneratorInterface<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){this.type = type;}

    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> GeneratorInterface<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
}
