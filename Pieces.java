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
public class Pieces
{
    // instance variables - replace the example below with your own
    private JButton[][] pos = new JButton[8][8];
    private King king = new King();
    private Queen queen = new Queen();
    private Bishop bishop = new Bishop();
    private Horse horse = new Horse();
    private Tower tower = new Tower();
    private Pawn pawn = new Pawn();
    private boolean queenMove = false;

    /**
     * Constructor for objects of class King
     */
    public Pieces()
    {
        // initialise instance variables
        
    }

    public boolean iconChecker(Icon thepiece){
        Icon piece = thepiece;
        boolean pieceCheck = true;
        
        if(piece == queen.getWhiteIcon()) pieceCheck = false;
        if(piece == king.getWhiteIcon()) pieceCheck = false;
        if(piece == bishop.getWhiteIcon()) pieceCheck = false;
        if(piece == horse.getWhiteIcon()) pieceCheck = false;
        if(piece == tower.getWhiteIcon()) pieceCheck = false;
        if(piece == pawn.getWhiteIcon()) pieceCheck = false;
        
        return pieceCheck;
    }
    
    public boolean clickedPiece(int x, int y){
        boolean isOrange = false;
        
        if(pos[x][y].getBackground() == Color.ORANGE) isOrange = true;
        
        return isOrange;
    }
    
}
