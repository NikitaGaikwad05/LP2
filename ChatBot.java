import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Customer Support ChatBot");
        System.out.println("Ask your question:");

        // User input
        String question = sc.nextLine().toLowerCase();

        // Chatbot response
        if (question.contains("hello") || question.contains("hi")) {

            System.out.println("Bot: Hello Customer!");

        } else if (question.contains("price")) {

            System.out.println("Bot: Product price is Rs.500");

        } else if (question.contains("delivery")) {

            System.out.println("Bot: Delivery takes 3 days");

        } else if (question.contains("payment")) {

            System.out.println("Bot: Payment can be done using UPI or Card");

        } else {

            System.out.println("Bot: Sorry, I don't understand");
        }

        sc.close();
    }
}