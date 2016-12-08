/**
 * Created by TangBin on 06/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.concurrent.*;
import net.mindview.util.*;
import static net.mindview.util.SwingConsole.*;

class CallableTask extends Task implements Callable<String>{
    public String call(){
        run();
        return "return value of "+this;
    }
}

public class InterruptableLongRunningCallable extends JFrame{
    private JButton
        b1 = new JButton("Start Long Runnning Task"),
        b2 = new JButton("End Long Running Task"),
        b3 = new JButton("Get results");
    private TaskManager<String, CallableTask> manager =
            new TaskManager<String, CallableTask>();
    public InterruptableLongRunningCallable(){
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallableTask task = new CallableTask();
                manager.add(task);
                System.out.println(task+" added to the queue");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(String result:manager.purge())
                    System.out.println(result);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    for(Object tt : manager)
                        ((TaskItem<String, CallableTask>)tt).task.id();
                    for(String result:manager.getResults())
                        System.out.println(result);
                }
        });
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
    }

    public static void main(String[] args) {
        run(new InterruptableLongRunningCallable(), 200, 150);
    }

}
