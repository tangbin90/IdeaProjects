package annotations;
/**
 * Created by TangBin on 26/10/2016.
 */

public class Testable {
    public void execute(){
        System.out.println("Executing..");
    }

    @Test void testExecute(){execute();}
}
