package annotations;

/**
 * Created by TangBin on 26/10/2016.
 */
import java.util.*;
public class passwordUtils {
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "new Passwords can't equal previously used ones")
    public boolean checkFornewPassword(List<String> prePasswords, String password){
        return !prePasswords.contains(password);
    }
}
