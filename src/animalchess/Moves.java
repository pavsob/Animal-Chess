package animalchess;
import java.util.ArrayList;
/**
 * Class that was added by the author. This class helps to determine legal moves in each kind of piece.
 * 
 */
public abstract class Moves {

    private static ArrayList<Square> possibleSquares = new ArrayList<Square>(0);

    /**
     * Sets square adepts for legal moves and adds them to array list possibleSquares.
     * 
     * @param currentSquare Current square
     * @param moveInRow Number of squares to move in row
     * @param moveInCol Number of squares to move in column
     */
    public static void setPossibleSquares(Square currentSquare, int moveInRow, int moveInCol) {
        int x = currentSquare.getRow() + moveInRow;
        int y = currentSquare.getCol() + moveInCol;
        if (currentSquare.getGame().isOnBoard(x, y)) {
            possibleSquares.add(currentSquare.getGame().getSquare(x, y));
        }
    }

    /**
     * Returns the array list of square adepts for legal moves.
     * 
     * @return ArrayList of Square
     */
    public static ArrayList<Square> getPossibleSquares() {
        return possibleSquares;
    }

    /**
     * Clear the array list of adepts.
     */
    public static void cleanPossibleSquares() {
        possibleSquares.clear();
    }
}
