/**
 * Created by TangBin on 07/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BangBean2 extends JPanel implements Serializable{
    private int xm, ym;
    private int cSize = 20;
    private String text = "Bang!";
    private int fontSize = 48;
    private Color tColor = Color.RED;
    private ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();
    public BangBean2(){
        addMouseListener(new ML());
        addMouseMotionListener(new MM());
    }

    public synchronized int getCircleSize(){
        return cSize;
    }

    public synchronized void setCircleSize(int newSize) {
        cSize = newSize;
    }

    public synchronized String getBangText(){
        return text;
    }
    public synchronized void setBangText(String newText){
        text = newText;
    }

    public synchronized Color getTextColor(){return tColor;}

    public synchronized void setTextColor(Color newColor) {
        tColor = newColor;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(xm - cSize/2, ym - cSize/2, cSize, cSize);
    }

    public synchronized void addActionListener(ActionListener l) {
        actionListeners.add(l);
    }

    public synchronized void removeActionListener(ActionListener l){
        actionListeners.remove(l);
    }

    public void notifyListeners(){
        ActionEvent a = new ActionEvent(BangBean2.this, ActionEvent.ACTION_PERFORMED, null);
        ArrayList<ActionListener> lv = null;
        synchronized (this) {
            lv = new ArrayList<ActionListener>(actionListeners);
        }
        for(ActionListener al : lv)
            al.actionPerformed(a);
    }
    class ML extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            Graphics g = getGraphics();
            g.setColor(tColor);
            g.setFont(
                    new Font("TimesRoman", Font.BOLD, fontSize)
            );
            int width = g.getFontMetrics().stringWidth(text);
            g.drawString(text, (getSize().width-width)/2, getSize().height/2);
            g.dispose();
            notifyListeners();
        }
    }

    class MM extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent event) {
            xm = event.getX();
            ym = event.getY();
            repaint();
        }
    }


}
