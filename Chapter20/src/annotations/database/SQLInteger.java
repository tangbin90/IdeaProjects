package annotations.database;
import java.lang.annotation.*;
/**
 * Created by TangBin on 28/10/2016.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}
