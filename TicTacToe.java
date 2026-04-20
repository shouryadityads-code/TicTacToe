import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    static int getUserSlot() {
        Scanner sc = new Scanner(System.in);
        int slot;

        System.out.print("Enter a slot number (1-9): ");
        slot = sc.nextInt();

        // Basic validation
        while (slot < 1 || slot > 9) {
            System.out.print("Invalid input! Enter a number between 1 and 9: ");
            slot = sc.nextInt();
        }

        return slot;
    }


}