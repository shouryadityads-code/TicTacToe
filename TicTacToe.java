/**
 * TicTacToe
 * UC10 checks whether the game has ended in a draw
 * by ensuring no empty cells remain on the board.
 */

public class TicTacToe {

    static char[][] board = new char[3][3];

    /**
     * Entry point of the program. Tests draw detection logic.
     */
    public static void main(String[] args) {

        initializeBoard();

        // Sample test case (FULL board, no '-')
        board[0][0] = 'X'; board[0][1] = 'O'; board[0][2] = 'X';
        board[1][0] = 'O'; board[1][1] = 'X'; board[1][2] = 'O';
        board[2][0] = 'O'; board[2][1] = 'X'; board[2][2] = 'O';

        printBoard();

        System.out.println("Is Draw? " + isDraw());
    }

    // Initialize board (from UC1)
    static void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    // Print board (reuse UC1 logic)
    static void printBoard() {
        System.out.println("\n-------------");
        for (int r = 0; r < 3; r++) {
            System.out.print("| ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    /**
     * Traverses the board to check for any remaining empty cells.
     * Output: true if draw, false otherwise.
     */
    static boolean isDraw() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}