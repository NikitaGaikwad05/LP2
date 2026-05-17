import java.util.*;

public class DFSBFSMenu {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    // Recursive DFS
    static void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // BFS
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : graph[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            // Undirected Graph
            graph[src].add(dest);
            graph[dest].add(src);
        }

        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Depth First Search (DFS)");
            System.out.println("2. Breadth First Search (BFS)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    visited = new boolean[vertices];

                    System.out.print("Enter starting vertex for DFS: ");
                    int dfsStart = sc.nextInt();

                    System.out.print("DFS Traversal: ");
                    dfs(dfsStart);
                    System.out.println();
                    break;

                case 2:
                    visited = new boolean[vertices];

                    System.out.print("Enter starting vertex for BFS: ");
                    int bfsStart = sc.nextInt();

                    System.out.print("BFS Traversal: ");
                    bfs(bfsStart);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
