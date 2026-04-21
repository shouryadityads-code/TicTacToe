public class TicTacToe {


    static char[][] board = {
        {'-','-','-'},
        {'-','-','-'},
        {'-','-','-'}
    };


    public static void main(String[] args) {
        System.out.println(isValidMove(1,1));
    }

    static boolean isValidMove(int row, int col) {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            return false;
        }

        row -= 1;
        col -= 1;

        if (board[row][col] == '-') {
            return true;
        }
        
        return false;
    }
}