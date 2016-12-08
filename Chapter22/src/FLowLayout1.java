/**
 * Created by TangBin on 02/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import static net.mindview.util.SwingConsole.*;

public class FLowLayout1 extends JFrame{
    public FLowLayout1(){
        setLayout(new FlowLayout());
        for(int i=0; i<20; i++)
            add(new JButton("Button"+i));
    }

    public static void main(String[] args){
        run(new FLowLayout1(), 300, 300);
    }

}
