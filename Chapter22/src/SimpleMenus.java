/**
 * Created by TangBin on 05/12/2016.
 */
import sun.java2d.pipe.SpanShapeRenderer;
import sun.management.snmp.jvminstr.JvmMemGCEntryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class SimpleMenus extends JFrame{
    private JTextField t = new JTextField(15);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            t.setText(((JMenuItem)e.getSource()).getText());
        }
    };
    private JMenu[] menus ={
            new JMenu("Winken"), new JMenu("Blinken"),
            new JMenu("Nod")
    };

    private JMenuItem[] items = {
            new JMenuItem("Fee"), new JMenuItem("Fi"),
            new JMenuItem("Fo"), new JMenuItem("zip"),
            new JMenuItem("Zap"), new JMenuItem("Zot"),
            new JMenuItem("Olly"), new JMenuItem("Oxen"),
            new JMenuItem("Free")
    };

    public SimpleMenus(){
        for(int i=0;i<items.length;i++){
            items[i].addActionListener(al);
            menus[i%3].add(items[i]);
        }

        JMenuBar mb = new JMenuBar();
        for(JMenu jm:menus)
            mb.add(jm);
        setJMenuBar(mb);
        setLayout(new FlowLayout());
        add(t);
    }

    public static void main(String[] args){
        run(new SimpleMenus(),200,150);
    }
}
