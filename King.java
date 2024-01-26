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
public class King
{
    // instance variables - replace the example below with your own
    private Icon blackKing = new ImageIcon("blackKing.png");
    private Icon whiteKing = new ImageIcon("whiteKing.png");

    /**
     * Constructor for objects of class King
     */
    public King()
    {
        // initialise instance variables
        
    }

    public Icon getBlackIcon(){
        return blackKing;
    }
    
    public Icon getWhiteIcon(){
        return whiteKing;
    }
    
}
