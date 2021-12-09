package animalchess;
import java.util.ArrayList;
/**
 * Class that defines particular piece Lion.
 * 
 */
public class Lion extends Piece {

    /**
     * Lion constructor calls super class constructor.
     * 
     * @param owner Owner of the piece
     * @param square Square of the piece
     */
    public Lion(Player owner, Square square) {
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
        //Possible moves for lion piece
        Moves.setPossibleSquares(this.getSquare(), 1, 1);
        Moves.setPossibleSquares(this.getSquare(), 1, -1);
        Moves.setPossibleSquares(this.getSquare(), -1, 1);
        Moves.setPossibleSquares(this.getSquare(), -1, -1);
        Moves.setPossibleSquares(this.getSquare(), 0, 1);
        Moves.setPossibleSquares(this.getSquare(), 0, -1);
        Moves.setPossibleSquares(this.getSquare(), -1, 0);
        Moves.setPossibleSquares(this.getSquare(), 1, 0);
        for (Square possibleSquare : Moves.getPossibleSquares()) {
            if (possibleSquare.getPiece() == null || possibleSquare.getPiece().getOwner() != this.getOwner()) {
                legalMoves.add(possibleSquare);
            }
        }
        Moves.cleanPossibleSquares();
        return legalMoves;
    }

    /**
     * Overridden beCaptured method from Piece. Sets capturer as the winner of the game.
     * 
     * @param capturer Capturer of the piece
     */
    @Override
    public void beCaptured(Player capturer) {
        capturer.winGame();
    }
}
