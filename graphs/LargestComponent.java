package graphs;

import java.util.*;

public class LargestComponent {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(8, 1, 5));
        graph.put(1, Arrays.asList(0));
        graph.put(5, Arrays.asList(0, 8));
        graph.put(8, Arrays.asList(0, 5));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3, 2));
        graph.put(20, Arrays.asList(9));
        graph.put(9, Arrays.asList(20));

        System.out.println(largestComponent(graph));
    }

    private static int largestComponent(HashMap<Integer, List<Integer>> graph) {
        int largest = Integer.MIN_VALUE;

        HashSet<Integer> visited = new HashSet<>();

        for (int node : graph.keySet()) {
            // if (!visited.contains(node)) {
            // largest = Math.max(largest, exploreSize(graph, node, visited));
            // }
            largest = Math.max(largest, exploreSize(graph, node, visited));
        }

        return largest;
    }

    private static int exploreSize(HashMap<Integer, List<Integer>> graph, int current, HashSet<Integer> visited) {
        if (visited.contains(current))
            return 0;

        visited.add(current);

        int count = 1;

        for (int neighbour : graph.get(current)) {
            count += exploreSize(graph, neighbour, visited);
        }

        return count;
    }
}
