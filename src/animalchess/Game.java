package animalchess;
/**
 * Class that defines a game.
 * 
 */
public class Game {

    /**
     * HEIGHT Height parameter of the board.
     */
    public static final int HEIGHT = 6;
    /**
     * WIDTH Width parameter of the board.
     */
    public static final int WIDTH = 5;
    private Player p0;
    private Player p1;
    private Square[][] board = new Square[HEIGHT][WIDTH];

    /**
     * Game constructor declares players of the game. Sets board and pieces on it.
     * 
     * @param p0 Player 0
     * @param p1 Player 1
     */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;
        this.setBoard();
        this.setPiecesOnBoard();
    }

    /**
     * Sets board for the game with squares.
     */
    private void setBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i < 2) {
                    Square newSquare = new Square(this, i, j, p1);
                    board[i][j] = newSquare;
                }
                else if (i > 3) {
                    Square newSquare = new Square(this, i, j, p0);
                    board[i][j] = newSquare;
                }
                else {
                    Square newSquare = new Square(this, i, j);
                    board[i][j] = newSquare;
                }
            }
        }
    }

    /**
     * Set particular pieces on the board before the game starts.
     */
    private void setPiecesOnBoard() {
        //Player 0 pieces
        new Cat(p0, board[0][0]);
        new Cat(p0, board[0][4]);
        new Dog(p0, board[0][1]);
        new Dog(p0, board[0][3]);
        new Lion(p0, board[0][2]);
        new Chick(p0, board[2][1]);
        new Chick(p0, board[2][2]);
        new Chick(p0, board[2][3]);
        //Player 1 pieces
        new Cat(p1, board[5][0]);
        new Cat(p1, board[5][4]);
        new Dog(p1, board[5][1]);
        new Dog(p1, board[5][3]);
        new Lion(p1, board[5][2]);
        new Chick(p1, board[3][1]);
        new Chick(p1, board[3][2]);
        new Chick(p1, board[3][3]);
    }

    /**
     * Checks whether a particular square is on board.
     * 
     * @param row Row of the square
     * @param col Column of the square
     * @return Returns true if the square is on board
     */
    public boolean isOnBoard(int row, int col) {
        if ((row <= (HEIGHT - 1) && row >= 0) && (col <= (WIDTH - 1) && col >= 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks whether a particular square is enemy's end line.
     * 
     * @param square Square to check
     * @param player Player on move
     * @return True if the square is enemy's end line
     */
    public boolean isEndLine(Square square, Player player) {
        if (player == p0) {
            if (square.getRow() == 5) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (player == p1) {
            if (square.getRow() == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * Returns a particular player according to the entered number.
     * 
     * @param playerNumber Number 0 or 1
     * @return Returns the player
     * @throws IllegalArgumentException Throws when other number than 0 or 1
     */
    public Player getPlayer(int playerNumber) throws IllegalArgumentException {
        if (playerNumber == 0) {
            return p0;
        }
        else if (playerNumber == 1) {
            return p1;
        }
        else {
            throw new IllegalArgumentException("Enter number between 0 and 1");
        }
    }

    /**
     * Returns the winner of the game.
     * 
     * @return Returns p0 or p1 or null
     */
    public Player getWinner() {
        if (p0.hasWon()) {
            return p0;
        }
        else if (p1.hasWon()) {
            return p1;
        }
        else {
            return null;
        }
    }

    /**
     * Returns a particular square from board according to entered row and column.
     * 
     * @param row Row of a square
     * @param col Column of a square
     * @return The square from board
     */
    public Square getSquare(int row, int col) {
        return board[row][col];
    }
}
