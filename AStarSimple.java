import java.util.*;

public class AStarSimple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];
        int h[] = new int[n];

        // Input graph
        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Input heuristic values
        System.out.println("Enter heuristic values:");

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        // Start and goal node
        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        System.out.print("Enter goal node: ");
        int goal = sc.nextInt();

        int current = start;

        System.out.println("Path:");

        // Simple A* logic
        while (current != goal) {

            System.out.print(current + " ");

            int min = 999;
            int next = -1;

            for (int i = 0; i < n; i++) {

                if (graph[current][i] > 0) {

                    int cost = graph[current][i] + h[i];

                    if (cost < min) {
                        min = cost;
                        next = i;
                    }
                }
            }

            current = next;
        }

        System.out.print(goal);
    }
}