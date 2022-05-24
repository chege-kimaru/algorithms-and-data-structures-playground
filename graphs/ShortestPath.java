package graphs;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("w", "x"),
                Arrays.asList("x", "y"),
                Arrays.asList("z", "y"),
                Arrays.asList("z", "v"),
                Arrays.asList("w", "v"));

        HashMap<String, List<String>> graph = buildGraph(edges);

        System.out.println(shortestPath(graph, "w", "x"));
    }

    private static HashMap<String, List<String>> buildGraph(List<List<String>> edges) {
        HashMap<String, List<String>> graph = new HashMap<>();

        for (List<String> edge : edges) {
            String a = edge.get(0);
            String b = edge.get(1);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }

    private static int shortestPath(HashMap<String, List<String>> graph, String nodeA, String nodeB) {
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(nodeA, 0));

        HashSet<String> visited = new HashSet<>();

        while (queue.size() > 0) {
            Path current = queue.poll();
            visited.add(current.node);

            if (current.node == nodeB)
                return current.distance;

            for (String neighbour : graph.get(current.node)) {
                if (!visited.contains(neighbour))
                    queue.add(new Path(neighbour, current.distance + 1));
            }
        }

        return -1;
    }

    static class Path {
        String node;
        int distance;

        Path(String node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
