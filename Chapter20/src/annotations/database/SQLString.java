package annotations.database;
import java.lang.annotation.*;
/**
 * Created by TangBin on 28/10/2016.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface SQLString {
    int value() default 0;
    String name() default "";
    Constraints contraints() default @Constraints;
}
