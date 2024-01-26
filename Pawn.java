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
public class Pawn
{
    // instance variables - replace the example below with your own
    private Icon blackPawn = new ImageIcon("blackPawn.png"); 
    private Icon whitePawn = new ImageIcon("whitePawn.png");

    /**
     * Constructor for objects of class King
     */
    public Pawn()
    {
        // initialise instance variables
        
    }

    public Icon getBlackIcon(){
        return blackPawn;
    }
    
    public Icon getWhiteIcon(){
        return whitePawn;
    }
    

    
}   

        
  