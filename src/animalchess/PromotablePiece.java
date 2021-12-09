package animalchess;
/**
 * Abstract class that extends Piece and defines a promotable piece (Cat and Chick).
 * 
 */
public abstract class PromotablePiece extends Piece {

    private boolean isPromoted = false;

    /**
     * PromotablePiece constructor calls super class constructor.
     * 
     * @param owner Owner of the piece
     * @param square Square of the piece
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Returns whether the current piece is promoted.
     * 
     * @return True if the piece is promoted
     */
    public boolean getIsPromoted() {
        return isPromoted;
    }

    /**
     * Promotes the current piece.
     */
    public void promote() {
        isPromoted = true;
    }

    /**
     * Overriden move method from Piece class. Move with the piece and promotes if the piece moves in or out the promotion zone
     * @param toSquare Where to move the piece
     */
    @Override
    public void move(Square toSquare) {
        toSquare.placePiece(this);
        this.getSquare().removePiece();
        setSquareNew(toSquare);
        if (!isPromoted) { //search for promotion only if it is not promoted already
            if ((toSquare.isPromotionZone(this.getOwner()) || (this.getSquare().isPromotionZone(this.getOwner())))) { //pridat nebo jestli uz je v promote zone a hybe se z ni ven tak povysit
                this.promote();
            }
        }
    }

    /**
     * Overriden move method from Piece class. Changes the owner of caprured piece and dispromotes.
     * 
     * @param capturer Capturer od the piece
     */
    @Override
    public void beCaptured(Player capturer) {
        isPromoted = false;
        setOwner(capturer);
    }
}
