import java.util.Scanner;
import java.util.Random;

/**
 * TicTacToe
 * UC1–UC9 Combined Implementation
 * Features:
 * - Board initialization & display
 * - Toss system (assign symbols)
 * - User input (slot-based)
 * - Move validation & placement
 * - Computer random move
 * - Continuous game loop
 * - Win detection (symbol-based)
 * - Draw detection
 */

public class TicTacToe {

    // UC1: Board
    static char[][] board = new char[3][3];

    // UC2: Game setup
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

        printBoard();

        // UC8: Continuous Game Loop
        while (!gameOver) {

            if (isHumanTurn) {
                System.out.println("\nHuman Turn (" + humanSymbol + ")");
                humanMove();   // UC3–UC6
            } else {
                System.out.println("\nComputer Turn (" + computerSymbol + ")");
                computerMove(); // UC7
            }

            printBoard();

            // UC9: Win check (symbol-based)
            if (hasWon(humanSymbol)) {
                System.out.println("🎉 Human Wins!");
                gameOver = true;
                break;
            }

            if (hasWon(computerSymbol)) {
                System.out.println("🤖 Computer Wins!");
                gameOver = true;
                break;
            }

            // Draw check
            if (checkDraw()) {
                System.out.println("It's a Draw!");
                gameOver = true;
                break;
            }

            // Switch turn
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

    // ---------------- UC9 ----------------
    static boolean hasWon(char symbol) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) return true;
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) return true;
        }

        // Diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) return true;

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) return true;

        return false;
    }

    // Draw check
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