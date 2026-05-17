import java.util.*;

public class ExpertSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hospital Expert System");
        System.out.println("1. Fever");
        System.out.println("2. Cold");
        System.out.println("3. Headache");

        System.out.print("Enter your problem number: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Advice: Take rest and drink warm water");
                break;

            case 2:
                System.out.println("Advice: Take cold medicine");
                break;

            case 3:
                System.out.println("Advice: Take pain relief tablet");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
