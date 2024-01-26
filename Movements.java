import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.function.UnaryOperator;


public class Movements {

    public Pawn pawn = new Pawn();
    public Tower tower = new Tower();
    public Horse horse = new Horse();
    public Bishop bishop = new Bishop();
    public Queen queen = new Queen();

    public King king = new King();
    public boolean playerTurn;



    public void movementManager(int x_value, int y_value, JButton[][] table){
        if(table[x_value][y_value].getBackground() == Color.GREEN || table[x_value][y_value].getBackground() == Color.RED){
            for (int a = 0; a < 8; a++)
                for (int b = 0; b < 8; b++)
                    if (table[a][b].getBackground() == Color.ORANGE) {
                        table[x_value][y_value].setIcon(table[a][b].getIcon());
                        break;
                    }

            for (int a = 0; a < 8; a++)
                for (int b = 0; b < 8; b++)
                    if (table[a][b].getBackground() == Color.ORANGE) table[a][b].setIcon(null);

            playerTurn = !playerTurn;
            System.out.println("Player turn: " + playerTurn);
            clearBackground(table);
        }
    }

    public void clearBackground(JButton[][] table){
        for(int y = 0; y<8; y++)
            for(int x=0; x<8; x++)
                if((x+y)%2==0) table[x][y].setBackground(Color.WHITE);
                else table[x][y].setBackground(new Color(128, 128, 128));
    }

    public void prepareMovements(int x_value, int y_value, JButton[][] table) {
        clearBackground(table);
        table[x_value][y_value].setBackground(Color.ORANGE);
    }


    public void whitePawnMovement(int x_value, int y_value, JButton[][] whitePawn){
        prepareMovements(x_value, y_value, whitePawn);
        if(y_value > 5){
            setPawnBackground(x_value, y_value - 1, whitePawn);
            setPawnBackground(x_value, y_value - 2, whitePawn);
        } else if (y_value - 1 >= 0) setPawnBackground(x_value, y_value - 1, whitePawn);

        setWhitePawnAttack(x_value - 1, y_value - 1, whitePawn);
        setWhitePawnAttack(x_value + 1, y_value - 1, whitePawn);
    }

    public void blackPawnMovement(int x_value, int y_value, JButton[][] blackPawn){
        prepareMovements(x_value, y_value, blackPawn);
        if(y_value < 2){
            setPawnBackground(x_value, y_value + 1, blackPawn);
            setPawnBackground(x_value, y_value + 2, blackPawn);
        } else if (y_value + 1 < 8) setPawnBackground(x_value, y_value + 1, blackPawn);
        setBlackPawnAttack(x_value - 1, y_value + 1, blackPawn);
        setBlackPawnAttack(x_value + 1, y_value + 1, blackPawn);
    }

    private void setPawnBackground(int x, int y, JButton[][] pPawn) {try {if (pPawn[x][y].getIcon() == null) pPawn[x][y].setBackground(Color.GREEN);} catch (ArrayIndexOutOfBoundsException ignored) {}}

    private void setBlackPawnAttack(int x, int y, JButton[][] pPawn) {
        Icon piece = pPawn[x][y].getIcon();
        try {if (piece != null) if (!checkKill(piece)) pPawn[x][y].setBackground(Color.RED);} catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    private void setWhitePawnAttack(int x, int y, JButton[][] pPawn) {
        Icon piece = pPawn[x][y].getIcon();
        try {if (piece != null) if (!checkKill(piece)) pPawn[x][y].setBackground(Color.RED);} catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public void kingMovement(int x_value, int y_value, JButton[][] kingMov){
        prepareMovements(x_value, y_value, kingMov);
        for(int pos_x = -1; pos_x <= 1; pos_x++){
            for(int pos_y = -1; pos_y <= 1; pos_y++){
                int new_pos_x = x_value + pos_x;
                int new_pos_y = y_value + pos_y;
                if(new_pos_x >= 0 && new_pos_x < 8 && new_pos_y >= 0 && new_pos_y < 8) if (kingMov[new_pos_x][new_pos_y].getIcon() == null || checkKill(kingMov[new_pos_x][new_pos_y].getIcon())) kingMov[new_pos_x][new_pos_y].setBackground(Color.GREEN);
            }
        }
    }

    public void horseMovement(int x_value, int y_value, JButton[][] horseMov){
        int[][] horseMovements = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        prepareMovements(x_value, y_value, horseMov);
        for(int[] horse : horseMovements) checkAndSetBackground(x_value + horse[0], y_value + horse[1], horseMov);
    }

    public void checkAndSetBackground(int pos_x, int pos_y, JButton[][] table){
        try {
            if (table[pos_x][pos_y].getIcon() == null) table[pos_x][pos_y].setBackground(Color.GREEN);
            else if (!checkKill(table[pos_x][pos_y].getIcon())) table[pos_x][pos_y].setBackground(Color.RED);
        }catch (ArrayIndexOutOfBoundsException ignored){}
    }

    public void towerMovement(int x_value, int y_value, JButton[][] table){
        prepareMovements(x_value, y_value, table);
        moveStraight(x_value, y_value, table);
    }

    public void queenMovement(int x_value, int y_value, JButton[][] table){
        prepareMovements(x_value, y_value, table);
        moveStraight(x_value, y_value, table);
        inclinedMovement(x_value, y_value, table);
    }

    public void bishopMovement(int x_value, int y_value, JButton[][] table){
        prepareMovements(x_value, y_value, table);
        inclinedMovement(x_value, y_value, table);
    }

    public void moveStraight(int xValue, int yValue, JButton[][] table) {
        checkAndHighlight(xValue, yValue, table, index -> index + 1, true);
        checkAndHighlight(xValue, yValue, table, index -> index - 1, true);
        checkAndHighlight(xValue, yValue, table, index -> index + 1, false);
        checkAndHighlight(xValue, yValue, table, index -> index - 1, false);
    }

    private void checkAndHighlight(int xValue, int yValue, JButton[][] table, UnaryOperator<Integer> directionOp, boolean isYFixed) {
        int a = directionOp.apply(isYFixed ? yValue : xValue);
        while (a >= 0 && a < 8) {
            JButton button = isYFixed ? table[xValue][a] : table[a][yValue];
            if (button.getIcon() == null) button.setBackground(Color.GREEN);
            else {
                if (!checkKill(isYFixed ? table[xValue][a].getIcon() : table[a][yValue].getIcon())) button.setBackground(Color.RED);
                break;
            }
            a = directionOp.apply(a);
        }
    }

    public void inclinedMovement(int x_value, int y_value, JButton[][] table) {
        // Upper left direction
        for (int pos_x = x_value - 1, pos_y = y_value - 1; pos_x >= 0 && pos_y >= 0; pos_x--, pos_y--) if (setIconAndBackgroundColor(pos_x, pos_y, table)) break;
        // Lower right direction
        for (int pos_x = x_value + 1, pos_y = y_value + 1; pos_x < 8 && pos_y < 8; pos_x++, pos_y++) if (setIconAndBackgroundColor(pos_x, pos_y, table)) break;
        // Upper right direction
        for (int pos_x = x_value + 1, pos_y = y_value - 1; pos_x < 8 && pos_y >= 0; pos_x++, pos_y--) if (setIconAndBackgroundColor(pos_x, pos_y, table)) break;
        // Lower left direction
        for (int pos_x = x_value - 1, pos_y = y_value + 1; pos_x >= 0 && pos_y < 8; pos_x--, pos_y++) if (setIconAndBackgroundColor(pos_x, pos_y, table)) break;
    }

    public boolean setIconAndBackgroundColor(int pos_x, int pos_y, JButton[][] piece) {
        try {
            if (piece[pos_x][pos_y].getIcon() == null) {
                piece[pos_x][pos_y].setBackground(Color.GREEN);
                return false;   // True because we can explore further positions
            } else if (!checkKill(piece[pos_x][pos_y].getIcon())) {
                piece[pos_x][pos_y].setBackground(Color.RED);
                return true;    // This is an opposing piece, so we stop here
            } else return true;   // This is an ally piece, so we stop here
        } catch (ArrayIndexOutOfBoundsException ex) {return true;} // if out of board boundary, halts further inclined movement checks
    }

    public boolean checkKill(Icon piece) {
        Icon[] whitePieces = {pawn.getWhiteIcon(), tower.getWhiteIcon(), horse.getWhiteIcon(), bishop.getWhiteIcon(), queen.getWhiteIcon(), king.getWhiteIcon()};
        return Arrays.asList(whitePieces).contains(piece);
    }

    public boolean getTurn() {return playerTurn;}





}
