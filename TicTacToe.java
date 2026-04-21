import java.util.Random;

public class TicTacToe {

    static char[][] board = {
        {'-','-','-'},
        {'-','-','-'},
        {'-','-','-'}
    };

    static char computerSymbol = 'O';
    static Random rand = new Random();

    public static void main(String[] args) {
        computerMove();
        printBoard();
    }

    static void computerMove() {
        int slot, row, col;

        while (true) {
            slot = rand.nextInt(9) + 1;

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }

    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row <= 2 &&
                col >= 0 && col <= 2 &&
                board[row][col] == '-');
    }

    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}