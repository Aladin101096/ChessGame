import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Write a description of class King here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tower
{
    // instance variables - replace the example below with your own
    private Icon blackTower = new ImageIcon("blackTower.png"); 
    private Icon whiteTower = new ImageIcon("whiteTower.png");

    /**
     * Constructor for objects of class King
     */
    public Tower()
    {
        // initialise instance variables
        
    }

    public Icon getBlackIcon(){
        return blackTower;
    }
    
    public Icon getWhiteIcon(){
        return whiteTower;
    }
    
    /**
    public void posibleTowerMovement(int x, int y){
        position[x][y].setBackground(Color.ORANGE);        
        moveLimit(x,y);
    }*/
}
