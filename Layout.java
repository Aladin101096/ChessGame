    import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class Layout here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Layout
{


    /**
     * Constructor for objects of class Layout
     */
    public Layout()
    {
        //Creating the frame to hold the game
        JFrame game = new JFrame();
        Container panel = game.getContentPane();
        panel.setLayout(new GridLayout(1,4));
        
        JPanel gamePanel = new JPanel(new GridLayout(8,8));
        gamePanel.setSize(1000,1000);

        Rules rules = new Rules();
        for(int y = 0; y<8; y++){
            for(int x=0; x<8; x++){
                gamePanel.add(rules.setTable(x,y));
            }
        }
        
        
        rules.setPieces();
        
        game.pack();
        game.setSize(1000,1000);
        game.setVisible(true);
        game.getContentPane();
        game.add(gamePanel);
    
        
        
    }

}

