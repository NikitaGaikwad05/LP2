import java.util.*;

class Ticket {
    int ticketId;
    String customerName;
    String issue;

    Ticket(int ticketId, String customerName, String issue) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issue = issue;
    }
}

public class HelpDeskManagement {

    static ArrayList<Ticket> tickets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Ticket
    public static void addTicket() {

        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Issue: ");
        String issue = sc.nextLine();

        tickets.add(new Ticket(id, name, issue));

        System.out.println("Ticket Added Successfully.");
    }

    // Display Tickets
    public static void displayTickets() {

        if (tickets.isEmpty()) {
            System.out.println("No Tickets Found.");
            return;
        }

        System.out.println("\nAll Help Desk Tickets:");

        for (Ticket t : tickets) {
            System.out.println("Ticket ID: " + t.ticketId);
            System.out.println("Customer Name: " + t.customerName);
            System.out.println("Issue: " + t.issue);
            System.out.println("----------------------");
        }
    }

    // Search Ticket
    public static void searchTicket() {

        System.out.print("Enter Ticket ID to Search: ");
        int id = sc.nextInt();

        for (Ticket t : tickets) {

            if (t.ticketId == id) {

                System.out.println("Ticket Found:");
                System.out.println("Customer Name: " + t.customerName);
                System.out.println("Issue: " + t.issue);
                return;
            }
        }

        System.out.println("Ticket Not Found.");
    }

    // Resolve/Delete Ticket
    public static void resolveTicket() {

        System.out.print("Enter Ticket ID to Resolve: ");
        int id = sc.nextInt();

        Iterator<Ticket> it = tickets.iterator();

        while (it.hasNext()) {

            Ticket t = it.next();

            if (t.ticketId == id) {

                it.remove();
                System.out.println("Ticket Resolved Successfully.");
                return;
            }
        }

        System.out.println("Ticket Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- Help Desk Management Expert System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Display Tickets");
            System.out.println("3. Search Ticket");
            System.out.println("4. Resolve Ticket");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTicket();
                    break;

                case 2:
                    displayTickets();
                    break;

                case 3:
                    searchTicket();
                    break;

                case 4:
                    resolveTicket();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
