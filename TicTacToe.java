import java.util.Random;

public class TicTacToe {

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;
    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
    }

    static void tossAndAssignSymbols() {
        Random r1 = new Random();
        int r2 = r1.nextInt(2);
        if(r2 == 0) {
            humanSymbol = 'X';
            computerSymbol = 'O';
            isHumanTurn = true;
        }
        else {
            humanSymbol = 'O';
            computerSymbol = 'X';
            isHumanTurn = false;
        }
    }

    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("Human won the toss and will play first.");
        } else {
            System.out.println("Computer won the toss and will play first.");
        }

        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }
}