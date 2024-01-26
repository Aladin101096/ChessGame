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
public class Queen
{
    // instance variables - replace the example below with your own
    private Icon blackQueen = new ImageIcon("blackQueen.png"); 
    private Icon whiteQueen = new ImageIcon("whiteQueen.png");

    /**
     * Constructor for objects of class King
     */
    public Queen()
    {
        // initialise instance variables
        
    }

    public Icon getBlackIcon(){
        return blackQueen;
    }
    
    public Icon getWhiteIcon(){
        return whiteQueen;
    }

}
