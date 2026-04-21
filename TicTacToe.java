public class TicTacToe {

    static char[][] board = {
        {'-','-','-'},
        {'-','-','-'},
        {'-','-','-'}
    };

    public static void main(String[] args) {
        placeMove(0, 0, 'X');
        System.out.println(board[0][0]);
    }

    static void placeMove(int row, int col, char symbol) {
        if (isValidMove(row, col)) {
            board[row][col] = symbol;
        } else {
            System.out.println("Invalid move!");
        }
    }

    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row <= 2 &&
                col >= 0 && col <= 2 &&
                board[row][col] == '-');
    }
}