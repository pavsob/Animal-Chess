package animalchess;
import java.util.ArrayList;
/**
 * Class that defines a player.
 * 
 */
public class Player {

    private String name;
    private int playerNumber;
    private boolean hasWonGame = false;
    private ArrayList<Piece> hand = new ArrayList<Piece>(0);

    /**
     * Player constructor sets name of a player and number.
     * 
     * @param name Name of the player
     * @param playerNumber Number of the player
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    /**
     * Returns player's name.
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns player's number.
     * 
     * @return Integer
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Returns what pieces are in the player's hand.
     * 
     * @return ArrayList of Pieces
     */
    public ArrayList<Piece> getHand() {
        return hand;
    }

    /**
     * Adds inputed piece into the hand.
     * 
     * @param piece Piece to hand
     */
    public void addPieceToHand(Piece piece) {
        piece.getSquare().removePiece();
        piece.setSquareNull();
        hand.add(piece);
    }

    /**
     * Drops piece on the board according to rules.
     * 
     * @param piece Piece to drop
     * @param square Square on which to place the piece
     * @throws IllegalArgumentException Throws an exception when inappropriate parameters entered
     */
    public void dropPiece(Piece piece, Square square) throws IllegalArgumentException {
        //can drop piece only on empty square and cannot drop on end line of the oponent
        if (square.getPiece() == null) {
            if (square.getGame() != null) {
                if ((!square.getGame().isEndLine(square, piece.getOwner())) && hand.remove(piece)) {
                    square.placePiece(piece);
                    piece.setSquareNew(square);
                }
            }
            else {
                if (hand.remove(piece)) {
                    square.placePiece(piece);
                    piece.setSquareNew(square);
                }
            }
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Makes the player to win the game.
     */
    public void winGame() {
        hasWonGame = true;
    }

    /**
     * Returns whether the player has won the game.
     * 
     * @return True if the player is the winner
     */
    public boolean hasWon() {
        return hasWonGame;
    }
}
