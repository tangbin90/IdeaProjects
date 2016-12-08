/**
 * Created by TangBin on 01/12/2016.
 */

import javax.swing.*;
import java.util.concurrent.*;

public class SubmitSwingProgram extends JFrame{
    JLabel label;
    public SubmitSwingProgram(){
        super("Hello Swing");
        label = new JLabel("A Label cant be display");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setVisible(true);
    }

    static SubmitSwingProgram ssp;
    public static void main(String[] args)throws Exception{
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){ssp = new SubmitSwingProgram();}
        });

        TimeUnit.SECONDS.sleep(10);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
}
