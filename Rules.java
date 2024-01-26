import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Analyze the chess game rules.
 *
 * @author Alaaeddine Sfali Sihadi
 * @version v1
 */
public class Rules implements ActionListener
{
    // instance variables - replace the example below with your own

    private final King king = new King();
    private final Queen queen = new Queen();
    private final Bishop bishop = new Bishop();
    private final Horse horse = new Horse();
    private final Tower tower = new Tower();
    private final Pawn pawn = new Pawn();
    public JButton[][] pos = new JButton[8][8];
    public Movements movements = new Movements();


    /**
     * Constructor for objects of class Rules
     */
    public Rules()
    {

    }

    public void actionPerformed(ActionEvent event){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(event.getSource() == pos[x][y]){
                    //CHECK IF KING IS IN CHECK



                        //MOVEMENT MANAGEMENT
                        if (!movements.getTurn()) {
                            //White Pawn Possible Movements
                            if (pos[x][y].getIcon() == pawn.getWhiteIcon()) movements.whitePawnMovement(x, y, pos);
                            // White King Possible Movements
                            if (pos[x][y].getIcon() == king.getWhiteIcon()) movements.kingMovement(x, y, pos);
                            // White Queen Possible Movements
                            if (pos[x][y].getIcon() == queen.getWhiteIcon()) movements.queenMovement(x, y, pos);
                            // White Bishop Possible Movements
                            if (pos[x][y].getIcon() == bishop.getWhiteIcon()) movements.bishopMovement(x, y, pos);
                            // White Horse Possible Movements
                            if (pos[x][y].getIcon() == horse.getWhiteIcon()) movements.horseMovement(x, y, pos);
                            //White Tower Possible Movements
                            if (pos[x][y].getIcon() == tower.getWhiteIcon()) movements.towerMovement(x, y, pos);
                        } else {
                            // Black Pawn possible movements
                            if (pos[x][y].getIcon() == pawn.getBlackIcon()) movements.blackPawnMovement(x, y, pos);
                            // Black King possible movements
                            if (pos[x][y].getIcon() == king.getBlackIcon()) movements.kingMovement(x, y, pos);
                            // Black Queen possible movements
                            if (pos[x][y].getIcon() == queen.getBlackIcon()) movements.queenMovement(x, y, pos);
                            // Black Bishop possible movements
                            if (pos[x][y].getIcon() == bishop.getBlackIcon()) movements.bishopMovement(x, y, pos);
                            // Black Horse Possible Movements
                            if (pos[x][y].getIcon() == horse.getBlackIcon()) movements.horseMovement(x, y, pos);
                            // Black Tower Possible Movements
                            if (pos[x][y].getIcon() == tower.getBlackIcon()) movements.towerMovement(x, y, pos);
                        }

                    //PIECE MOVEMENT MANAGEMENT
                    movements.movementManager(x,y,pos);
                }
            }
        }
    }


    /**
     * Method that set up the chess table.
     */
    public void setPieces() {
        int black = 0;
        int white = 7;
        setSingleColorPieces(black, false);
        setSingleColorPieces(white, true);
    }

    // Set up the pieces for a single color
    private void setSingleColorPieces(int row, boolean isWhite) {
        Icon kingIcon = isWhite ? king.getWhiteIcon() : king.getBlackIcon();
        Icon queenIcon = isWhite ? queen.getWhiteIcon() : queen.getBlackIcon();
        Icon bishopIcon = isWhite ? bishop.getWhiteIcon() : bishop.getBlackIcon();
        Icon horseIcon = isWhite ? horse.getWhiteIcon() : horse.getBlackIcon();
        Icon towerIcon = isWhite ? tower.getWhiteIcon() : tower.getBlackIcon();
        Icon pawnIcon = isWhite ? pawn.getWhiteIcon() : pawn.getBlackIcon();

        pos[3][row].setIcon(kingIcon);
        pos[4][row].setIcon(queenIcon);
        pos[2][row].setIcon(bishopIcon);
        pos[5][row].setIcon(bishopIcon);
        pos[1][row].setIcon(horseIcon);
        pos[6][row].setIcon(horseIcon);
        pos[0][row].setIcon(towerIcon);
        pos[7][row].setIcon(towerIcon);

        // Set pawn icons
        for (int i = 0; i < 8; i++) pos[i][isWhite ? row - 1 : row + 1].setIcon(pawnIcon);
    }

    /**
     * Method that set up the chess table.
     */
    public JButton setTable(int x, int y){
        pos[x][y] = new JButton();
        pos[x][y].setSize(10,10);
        pos[x][y].setVisible(true);
        pos[x][y].addActionListener(this);
        if((x+y)%2 == 0) pos[x][y].setBackground(Color.WHITE);
        else pos[x][y].setBackground(new Color(128, 128, 128));

        return pos[x][y];
    }

}
