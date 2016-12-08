/**
 * Created by TangBin on 06/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class HTMLButton extends JFrame{
    private JButton b = new JButton(
            "<html><b><font size=+2>"+
                    "<center>Hello!<br><i>Press me now!"
    );

    public HTMLButton() {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new Label("<html>"+
                    "<i><font size=+4>Kapow!"));
                validate();
            }
        });
        setLayout(new FlowLayout());
        add(b);
    }

    public static void main(String[] args) {
        run(new HTMLButton(), 200, 500);
    }
}

