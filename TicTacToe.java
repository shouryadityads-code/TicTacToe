import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    // UC1: Board
    static char[][] board = new char[3][3];

    // UC2: Toss variables
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    // UC8: Game state
    static boolean gameOver = false;

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        // UC1
        initializeBoard();

        // UC2
        tossAndAssignSymbols();
        displayTossResult();

        // Show board
        printBoard();

        // UC8: Continuous Loop
        while (!gameOver) {

            if (isHumanTurn) {
                System.out.println("\nHuman Turn (" + humanSymbol + ")");
                humanMove();   // UC3–UC6
            } else {
                System.out.println("\nComputer Turn (" + computerSymbol + ")");
                computerMove(); // UC7
            }

            printBoard();

            // UC8: Win check (added)
            if (checkWin()) {
                if (isHumanTurn) {
                    System.out.println("Human Wins!");
                } else {
                    System.out.println("Computer Wins!");
                }
                gameOver = true;
                break;
            }

            // UC8: Draw check (added)
            if (checkDraw()) {
                System.out.println("It's a Draw!");
                gameOver = true;
                break;
            }

            // UC8: Switch turn
            isHumanTurn = !isHumanTurn;
        }

        sc.close();
    }

    // ---------------- UC1 ----------------
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // ---------------- UC2 ----------------
    static void tossAndAssignSymbols() {
        int toss = rand.nextInt(2);

        if (toss == 0) {
            humanSymbol = 'X';
            computerSymbol = 'O';
            isHumanTurn = true;
        } else {
            humanSymbol = 'O';
            computerSymbol = 'X';
            isHumanTurn = false;
        }
    }

    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("Human won the toss and plays first.");
        } else {
            System.out.println("Computer won the toss and plays first.");
        }

        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }

    // ---------------- UC3 ----------------
    static int getUserSlot() {
        int slot;

        System.out.print("Enter slot (1-9): ");
        slot = sc.nextInt();

        while (slot < 1 || slot > 9) {
            System.out.print("Invalid! Enter 1-9: ");
            slot = sc.nextInt();
        }

        return slot;
    }

    // ---------------- UC4 ----------------
    static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // ---------------- UC5 ----------------
    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-');
    }

    // ---------------- UC6 ----------------
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    static void humanMove() {
        int slot, row, col;

        while (true) {
            slot = getUserSlot();
            row = getRow(slot);
            col = getCol(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, humanSymbol);
                break;
            } else {
                System.out.println("Cell already occupied! Try again.");
            }
        }
    }

    // ---------------- UC7 ----------------
    static void computerMove() {
        int slot, row, col;

        while (true) {
            slot = rand.nextInt(9) + 1;
            row = getRow(slot);
            col = getCol(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }

    // ---------------- UC8 ADDITIONS ----------------
    static boolean checkWin() {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) return true;

            if (board[0][i] != '-' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) return true;
        }

        // Diagonals
        if (board[0][0] != '-' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) return true;

        if (board[0][2] != '-' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) return true;

        return false;
    }

    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}