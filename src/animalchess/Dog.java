package animalchess;
import java.util.ArrayList;
/**
 * Class that defines particular piece Dog.
 * 
 */
public class Dog extends Piece {

    /**
     * Dog constructor calls super class constructor.
     * 
     * @param owner Owner of the piece
     * @param square Square of the piece
     */
    public Dog(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Gets an array list of legal moves.
     * 
     * @return ArrayList of Square
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        legalMoves.clear();
        if (this.getOwner().getPlayerNumber() == 0) {
            Moves.setPossibleSquares(this.getSquare(), 1, 1);
            Moves.setPossibleSquares(this.getSquare(), 1, -1);
            Moves.setPossibleSquares(this.getSquare(), 1, 0);
            Moves.setPossibleSquares(this.getSquare(), -1, 0);
            Moves.setPossibleSquares(this.getSquare(), 0, 1);
            Moves.setPossibleSquares(this.getSquare(), 0, -1);
        }
        else if (this.getOwner().getPlayerNumber() == 1) {
            Moves.setPossibleSquares(this.getSquare(), -1, -1);
            Moves.setPossibleSquares(this.getSquare(), -1, 1);
            Moves.setPossibleSquares(this.getSquare(), -1, 0);
            Moves.setPossibleSquares(this.getSquare(), 1, 0);
            Moves.setPossibleSquares(this.getSquare(), 0, 1);
            Moves.setPossibleSquares(this.getSquare(), 0, -1);
        }
        for (Square possibleSquare : Moves.getPossibleSquares()) {
            if ((possibleSquare.getPiece() == null) || (possibleSquare.getPiece().getOwner() != this.getOwner())) {
                legalMoves.add(possibleSquare);
            }
        }
        Moves.cleanPossibleSquares();
        return legalMoves;
    }
}
