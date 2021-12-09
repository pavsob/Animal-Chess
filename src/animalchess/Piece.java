package animalchess;
import java.util.ArrayList;
/**
 * Abstract class that defines a piece.
 * 
 */
public abstract class Piece {

    private Player owner;
    private Square square;
    protected ArrayList<Square> legalMoves = new ArrayList<Square>(0);

    /**
     * Abstract method for getting array list of legal moves.
     * 
     * @return Array of Square
     */
    public abstract ArrayList<Square> getLegalMoves();

    /**
     * Piece constructor sets owner and square of the piece, and places it on the square through square's placePiece method.
     * 
     * @param owner Owner of the piece
     * @param square Square of the piece
     */
    public Piece(Player owner, Square square) {
        this.owner = owner;
        this.square = square;
        square.placePiece(this);
    }

    /**
     * Moves piece from current square to another.
     * 
     * @param toSquare Square where to move the piece
     */
    public void move(Square toSquare) {
        toSquare.placePiece(this);
        square.removePiece();
        setSquareNew(toSquare); // square = toSquare; //tady pouzit metodu!
    }

    /**
     * When piece gets captured it changes the owner.
     * 
     * @param capturer Capturer od the piece
     */
    public void beCaptured(Player capturer) {
        setOwner(capturer);
    }

    /**
     * Sets entered player as an owner.
     * 
     * @param capturer Capturer od the piece
     */
    public void setOwner(Player capturer) {
        owner = capturer;
    }

    /**
     * Sets piece's square to null - used in Player addPieceToHand method.
     */
    protected void setSquareNull() {
        square = null;
    }

    /**
     * Sets entered square as the piece's square.
     * 
     * @param newSquare New square for the piece
     */
    protected void setSquareNew(Square newSquare) {
        square = newSquare;
    }

    /**
     * Returns piece's square.
     * 
     * @return Square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * Returns the player who owns the piece.
     * 
     * @return Player
     */
    public Player getOwner() {
        return owner;
    }
}
