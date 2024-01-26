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
public class Bishop
{
    // instance variables - replace the example below with your own
    private Icon blackBishop = new ImageIcon("blackBishop.png"); 
    private Icon whiteBishop = new ImageIcon("whiteBishop.png");

    /**
     * Constructor for objects of class King
     */
    public Bishop()
    {
        // initialise instance variables
        
    }

    public Icon getBlackIcon(){
        return blackBishop;
    }
    
    public Icon getWhiteIcon(){
        return whiteBishop;
    }
   
}
