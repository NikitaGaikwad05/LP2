import java.util.*;

public class JobScheduling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        int profit[] = new int[n];
        int deadline[] = new int[n];
        char job[] = new char[n];

        // Input jobs
        for (int i = 0; i < n; i++) {

            job[i] = (char) ('A' + i);

            System.out.print("Enter profit of job " + job[i] + ": ");
            profit[i] = sc.nextInt();

            System.out.print("Enter deadline of job " + job[i] + ": ");
            deadline[i] = sc.nextInt();
        }

        // Sorting by profit (Descending)
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (profit[i] < profit[j]) {

                    int temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = temp;

                    char t = job[i];
                    job[i] = job[j];
                    job[j] = t;
                }
            }
        }

        boolean slot[] = new boolean[n];

        System.out.println("Selected Jobs:");

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = Math.min(n, deadline[i]) - 1; j >= 0; j--) {

                if (!slot[j]) {

                    slot[j] = true;

                    System.out.println(job[i]);

                    totalProfit += profit[i];
                    break;
                }
            }
        }

        System.out.println("Total Profit = " + totalProfit);

        sc.close();
    }
}
