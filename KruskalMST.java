import java.util.*;

public class KruskalMST {

    static int parent[] = new int[10];

    static int find(int i) {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }

    static void union(int a, int b) {
        parent[b] = a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int edges = 0;
        int minCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        while (edges < n - 1) {

            int min = 999, a = -1, b = -1;

            // Find minimum edge
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (graph[i][j] < min && graph[i][j] != 0) {
                        min = graph[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            int u = find(a);
            int v = find(b);

            // Avoid cycle
            if (u != v) {

                union(u, v);

                System.out.println(a + " - " + b + " = " + min);

                minCost += min;
                edges++;
            }

            // Remove selected edge
            graph[a][b] = graph[b][a] = 999;
        }

        System.out.println("Minimum Cost = " + minCost);

        sc.close();
    }
}
