import java.util.*;

class Flight {

    int flightId;
    String flightName;
    String destination;
    double cargoWeight;
    String cargoStatus;

    Flight(int flightId, String flightName,
           String destination, double cargoWeight) {

        this.flightId = flightId;
        this.flightName = flightName;
        this.destination = destination;
        this.cargoWeight = cargoWeight;

        // Expert System Rule
        if (cargoWeight <= 1000)
            cargoStatus = "Normal Cargo";

        else
            cargoStatus = "Heavy Cargo";
    }
}

public class AirlineScheduling {

    static ArrayList<Flight> flights = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Flight Schedule
    public static void addFlight() {

        System.out.print("Enter Flight ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Flight Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Cargo Weight (kg): ");
        double weight = sc.nextDouble();

        flights.add(new Flight(id, name, destination, weight));

        System.out.println("Flight Schedule Added Successfully.");
    }

    // Display Flight Schedules
    public static void displayFlights() {

        if (flights.isEmpty()) {
            System.out.println("No Flight Records Found.");
            return;
        }

        System.out.println("\nFlight and Cargo Details:");

        for (Flight f : flights) {

            System.out.println("Flight ID: " + f.flightId);
            System.out.println("Flight Name: " + f.flightName);
            System.out.println("Destination: " + f.destination);
            System.out.println("Cargo Weight: " + f.cargoWeight + " kg");
            System.out.println("Cargo Status: " + f.cargoStatus);
            System.out.println("---------------------------");
        }
    }

    // Search Flight
    public static void searchFlight() {

        System.out.print("Enter Flight ID to Search: ");
        int id = sc.nextInt();

        for (Flight f : flights) {

            if (f.flightId == id) {

                System.out.println("Flight Found:");
                System.out.println("Flight Name: " + f.flightName);
                System.out.println("Destination: " + f.destination);
                System.out.println("Cargo Status: " + f.cargoStatus);
                return;
            }
        }

        System.out.println("Flight Record Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- Airline Scheduling and Cargo Expert System ---");
            System.out.println("1. Add Flight Schedule");
            System.out.println("2. Display Flight Schedules");
            System.out.println("3. Search Flight");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addFlight();
                    break;

                case 2:
                    displayFlights();
                    break;

                case 3:
                    searchFlight();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
