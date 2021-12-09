package animalchess;
import java.util.ArrayList;
/**
 * Class that defines the game.
 * 
 */
public class Cat extends PromotablePiece {

    /**
     * Cat constructor calls super class constructor.
     * 
     * @param owner Owner of the piece
     * @param square Square of the piece
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Gets an array list of legal moves.
     * 
     * @return ArrayList of Square
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        //if isPromoted true - moves like Dog
        legalMoves.clear();
        if (this.getIsPromoted()) {
            if (this.getOwner().getPlayerNumber() == 0) {
                Moves.setPossibleSquares(this.getSquare(), 1, 1);
                Moves.setPossibleSquares(this.getSquare(), 1, -1);
                Moves.setPossibleSquares(this.getSquare(), 1, 0);
                Moves.setPossibleSquares(this.getSquare(), -1, 0);
                Moves.setPossibleSquares(this.getSquare(), 0, 1);
                Moves.setPossibleSquares(this.getSquare(), 0, -1);
            }
            if (this.getOwner().getPlayerNumber() == 1) {
                Moves.setPossibleSquares(this.getSquare(), -1, -1);
                Moves.setPossibleSquares(this.getSquare(), -1, 1);
                Moves.setPossibleSquares(this.getSquare(), -1, 0);
                Moves.setPossibleSquares(this.getSquare(), 1, 0);
                Moves.setPossibleSquares(this.getSquare(), 0, 1);
                Moves.setPossibleSquares(this.getSquare(), 0, -1);
            }
        }
        else {
            if (this.getOwner().getPlayerNumber() == 0) {
                Moves.setPossibleSquares(this.getSquare(), 1, 1);
                Moves.setPossibleSquares(this.getSquare(), 1, 0);
                Moves.setPossibleSquares(this.getSquare(), 1, -1);
                Moves.setPossibleSquares(this.getSquare(), -1, -1);
                Moves.setPossibleSquares(this.getSquare(), -1, 1);
            }
            if (this.getOwner().getPlayerNumber() == 1) {
                Moves.setPossibleSquares(this.getSquare(), -1, -1);
                Moves.setPossibleSquares(this.getSquare(), -1, 0);
                Moves.setPossibleSquares(this.getSquare(), -1, 1);
                Moves.setPossibleSquares(this.getSquare(), 1, -1);
                Moves.setPossibleSquares(this.getSquare(), 1, 1);
            }
        }
        for (Square possibleSquare : Moves.getPossibleSquares()) {
            if (possibleSquare.getPiece() == null || possibleSquare.getPiece().getOwner() != this.getOwner()) {
                legalMoves.add(possibleSquare);
            }
        }
        Moves.cleanPossibleSquares();
        return legalMoves;
    }
}
