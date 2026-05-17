import java.util.*;

class Stock {

    int stockId;
    String companyName;
    double priceChange;
    String suggestion;

    Stock(int stockId, String companyName, double priceChange) {

        this.stockId = stockId;
        this.companyName = companyName;
        this.priceChange = priceChange;

        // Expert System Rules
        if (priceChange > 10)
            suggestion = "BUY";

        else if (priceChange >= 0)
            suggestion = "HOLD";

        else
            suggestion = "SELL";
    }
}

public class StockMarketTrading {

    static ArrayList<Stock> stocks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Stock
    public static void addStock() {

        System.out.print("Enter Stock ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();

        System.out.print("Enter Price Change Percentage: ");
        double change = sc.nextDouble();

        stocks.add(new Stock(id, company, change));

        System.out.println("Stock Record Added Successfully.");
    }

    // Display Stocks
    public static void displayStocks() {

        if (stocks.isEmpty()) {
            System.out.println("No Stock Records Found.");
            return;
        }

        System.out.println("\nStock Market Details:");

        for (Stock s : stocks) {

            System.out.println("Stock ID: " + s.stockId);
            System.out.println("Company Name: " + s.companyName);
            System.out.println("Price Change: " + s.priceChange + "%");
            System.out.println("Trading Suggestion: " + s.suggestion);
            System.out.println("--------------------------");
        }
    }

    // Search Stock
    public static void searchStock() {

        System.out.print("Enter Stock ID to Search: ");
        int id = sc.nextInt();

        for (Stock s : stocks) {

            if (s.stockId == id) {

                System.out.println("Stock Found:");
                System.out.println("Company Name: " + s.companyName);
                System.out.println("Price Change: " + s.priceChange + "%");
                System.out.println("Suggestion: " + s.suggestion);
                return;
            }
        }

        System.out.println("Stock Record Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- Stock Market Trading Expert System ---");
            System.out.println("1. Add Stock");
            System.out.println("2. Display Stocks");
            System.out.println("3. Search Stock");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStock();
                    break;

                case 2:
                    displayStocks();
                    break;

                case 3:
                    searchStock();
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
