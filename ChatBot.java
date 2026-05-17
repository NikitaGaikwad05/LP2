import java.util.*;

public class ChatBot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Simple ChatBot");
        System.out.println("Type bye to exit");

        while (true) {

            System.out.print("You: ");
            String msg = sc.nextLine();

            if (msg.equalsIgnoreCase("hello")) {
                System.out.println("Bot: Hello User");
            }

            else if (msg.equalsIgnoreCase("price")) {
                System.out.println("Bot: Price is Rs.500");
            }

            else if (msg.equalsIgnoreCase("bye")) {
                System.out.println("Bot: Thank You");
                break;
            }

            else {
                System.out.println("Bot: I don't understand");
            }
        }

        sc.close();
    }
}
