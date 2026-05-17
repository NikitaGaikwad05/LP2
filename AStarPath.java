import java.util.*;

class AStarPath {

    // Graph connections
    static Map<String, List<String>> graph = new HashMap<>();

    // Heuristic values
    static Map<String, Integer> heuristic = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating graph
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("D", "G"));
        graph.put("D", Arrays.asList("G"));
        graph.put("G", new ArrayList<>());

        // Heuristic values
        heuristic.put("A", 7);
        heuristic.put("B", 6);
        heuristic.put("C", 2);
        heuristic.put("D", 1);
        heuristic.put("G", 0);

        // User input
        System.out.print("Enter Start Node: ");
        String start = sc.next();

        System.out.print("Enter Goal Node: ");
        String goal = sc.next();

        String current = start;

        System.out.println("Path:");

        // A* Search
        while (!current.equals(goal)) {

            System.out.print(current + " -> ");

            List<String> neighbors = graph.get(current);

            String nextNode = null;
            int min = Integer.MAX_VALUE;

            // Select node with minimum heuristic
            for (String node : neighbors) {

                int h = heuristic.get(node);

                if (h < min) {
                    min = h;
                    nextNode = node;
                }
            }

            current = nextNode;
        }

        System.out.println(goal);

        sc.close();
    }
}
