/**
 * Created by TangBin on 07/12/2016.
 */
import java.awt.*;
import java.awt.event.*;

class Spots{}

public class Frog {
    private int jumps;
    private Color color;
    private Spots spots;
    private boolean jumpr;
    public int getJumps(){return jumps;}
    public void setJumps(int newJumps){
        jumps = newJumps;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color newColor){
        color = newColor;
    }

    public Spots getSpots(){
        return spots;
    }

    public void setSpots(Spots newspots){
        spots = newspots;
    }

    public boolean isJumper(){
        return jumpr;
    }

    public void setJumpr(boolean j){jumpr = j;}

    public void addActionListener(ActionListener l){

    }

    public void removeActionListener(ActionListener l){

    }

    public void addKeyListener(KeyListener l){

    }

    public void removeKeyListener(KeyListener l){

    }

    public void croak(){
        System.out.println("Ribbet!");
    }
}
