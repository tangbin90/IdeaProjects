/**
 * Created by TangBin on 01/12/2016.
 */

import javax.swing.*;
import java.util.concurrent.*;
public class HelloSwing {

    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                label.setText("Hey! This is Different!");
            }
        });
    }
}
