import java.util.*;

public class GraphTraversal {

    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor
    GraphTraversal(int v) {

        vertices = v;
        adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    // Add edge
    void addEdge(int v, int w) {

        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    // DFS
    void DFS(int vertex, boolean visited[]) {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjacent : adjList.get(vertex)) {

            if (!visited[adjacent]) {
                DFS(adjacent, visited);
            }
        }
    }

    // BFS
    void BFS(int startVertex) {

        boolean visited[] = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            System.out.print(vertex + " ");

            for (int adjacent : adjList.get(vertex)) {

                if (!visited[adjacent]) {

                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        GraphTraversal g = new GraphTraversal(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges:");

        for (int i = 0; i < e; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            g.addEdge(source, destination);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.println("\nDFS Traversal:");
        boolean visited[] = new boolean[v];
        g.DFS(start, visited);

        System.out.println("\n\nBFS Traversal:");
        g.BFS(start);

        sc.close();
    }
}