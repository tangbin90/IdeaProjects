/**
 * Created by TangBin on 07/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;

class CBox extends JPanel implements Runnable{
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);

    public void paintComponent(Graphics graphics) {
        graphics.setColor(color);
        Dimension s = getSize();
        graphics.fillRect(0,0,s.width, s.height);
    }

    public CBox(int pause) {
        this.pause = pause;
    }

    public void run(){
        try {
            while (!Thread.interrupted()) {
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint();
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class ColorBoxes extends JFrame{
    private int grid = 12;
    private int pause = 500;
    private static ExecutorService exec = Executors.newCachedThreadPool();
    public void setUp(){
        setLayout(new GridLayout(grid, grid));
        for(int i=0;i<grid*grid;i++){
            CBox cb = new CBox(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        ColorBoxes boxes = new ColorBoxes();
        if(args.length>0)
            boxes.grid = new Integer(args[0]);
        if(args.length>1)
            boxes.pause = new Integer(args[1]);
        boxes.setUp();
        run(boxes, 500, 400);
    }
}
