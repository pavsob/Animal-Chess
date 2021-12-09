package animalchess;
/**
 * Class that defines a square.
 * 
 */
public class Square {

    private Game game;
    private int row;
    private int col;
    private Player promotesPlayer;
    private Piece placedPiece = null;

    /**
     * First Square constructor.
     * 
     * @param game Sets the square's game
     * @param row Sets the square's row
     * @param col Sets the square's column
     */
    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }

    /**
     * Second Square constructur.
     * 
     * @param game Sets the square's game
     * @param row Sets the square's row
     * @param col Sets the square's column
     * @param promotesPlayer If the square is promoting square, it says which player to promote
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
    }

    /**
     * Places the piace on the square.
     * 
     * @param piece Piece to place
     * @throws IllegalArgumentException Throws an exception when an inappropriate piece is entered
     */
    public void placePiece(Piece piece) throws IllegalArgumentException {
        if (this.placedPiece == null) {
            placedPiece = piece;
        }
        else if (piece.getOwner() != placedPiece.getOwner()) {
            placedPiece.beCaptured(piece.getOwner());
            piece.getOwner().addPieceToHand(placedPiece);
            placedPiece = piece;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Removes piece from the square.
     */
    public void removePiece() {
        placedPiece = null;
    }

    /**
     * Returns whether the square is a promotion zone.
     * 
     * @param player Player for promotion check
     * @return True if the square promotes the player's piece
     */
    public boolean isPromotionZone(Player player) {
        if (promotesPlayer == null) {
            return false;
        }
        else if (promotesPlayer.getPlayerNumber() == player.getPlayerNumber()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns the square's game.
     * 
     * @return Game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Returns the piece placed on the square.
     * 
     * @return Placed piece
     */
    public Piece getPiece() {
        return placedPiece;
    }

    /**
     * Returns the row integer number of the square.
     * 
     * @return Row integer
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column integer number of the square.
     * 
     * @return Column integer
     */
    public int getCol() {
        return col;
    }
}
