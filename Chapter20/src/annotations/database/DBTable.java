package annotations.database;

/**
 * Created by TangBin on 27/10/2016.
 */
import java.lang.annotation.*;

@Target(ElementType.TYPE)//该注解只能够用于
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}

