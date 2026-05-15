import java.util.Scanner;

public class HelpDeskExpertSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Help Desk Expert System ===");

        System.out.println("1. Internet Problem");
        System.out.println("2. Password Problem");
        System.out.println("3. Slow Computer");
        System.out.println("4. Printer Problem");

        System.out.print("\nEnter your choice: ");

        int choice = sc.nextInt();

        // Expert system rules
        switch (choice) {

            case 1:
                System.out.println("Solution: Restart the router.");
                break;

            case 2:
                System.out.println("Solution: Reset your password.");
                break;

            case 3:
                System.out.println("Solution: Close unused applications.");
                break;

            case 4:
                System.out.println("Solution: Check printer connection.");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}