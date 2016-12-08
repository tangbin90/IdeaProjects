/**
 * Created by TangBin on 07/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;

public class BangBeanTest2 extends JFrame{
    public BangBeanTest2(){
        BangBean2 bb2 = new BangBean2();
        bb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent"+e);
            }
        });
        bb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("BangBean2 action");
            }
        });
        bb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("More action");
            }
        });
        add(bb2);
    }
    public static void main(String[] args) {

        run(new BangBeanTest2(),300, 300);
    }
}
