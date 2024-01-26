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
public class Horse
{
    // instance variables - replace the example below with your own
    private Icon blackHorse = new ImageIcon("blackHorse.png"); 
    private Icon whiteHorse = new ImageIcon("whiteHorse.png");

    /**
     * Constructor for objects of class King
     */
    public Horse()
    {
        // initialise instance variables
        
    }

    public Icon getBlackIcon(){
        return blackHorse;
    }
    
    public Icon getWhiteIcon(){
        return whiteHorse;
    }
}
