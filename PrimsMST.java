import java.util.Scanner;

public class PrimsMST {

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

        boolean visited[] = new boolean[n];

        visited[0] = true;

        int edges = 0;
        int minCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        while (edges < n - 1) {

            int min = 999;
            int x = 0, y = 0;

            for (int i = 0; i < n; i++) {

                if (visited[i]) {

                    for (int j = 0; j < n; j++) {

                        if (!visited[j] && graph[i][j] != 0) {

                            if (graph[i][j] < min) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " = " + graph[x][y]);

            minCost += graph[x][y];
            visited[y] = true;
            edges++;
        }

        System.out.println("Minimum Cost = " + minCost);

        sc.close();
    }
}
