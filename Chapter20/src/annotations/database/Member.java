package annotations.database;

import java.lang.invoke.LambdaConversionException;

/**
 * Created by TangBin on 28/10/2016.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, contraints = @Constraints(primaryKey = true))
    String handle;
    static int memeberCount;
    public String getHandle(){return handle;}
    public String getFirstName(){return firstName;}
    public String toString(){return handle;}
    public String getLastName(){return lastName;}
    public Integer getAge(){return age;}
}
