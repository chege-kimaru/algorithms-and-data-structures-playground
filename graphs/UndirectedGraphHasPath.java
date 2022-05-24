package graphs;

import java.util.*;

public class UndirectedGraphHasPath {
    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("i", "j"),
                Arrays.asList("k", "i"),
                Arrays.asList("m", "k"),
                Arrays.asList("k", "l"),
                Arrays.asList("o", "n"));

        HashMap<String, List<String>> graph = buildGraph(edges);

        System.out.println(hasPath(graph, "j", "m", new HashSet<String>()));
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

    private static boolean hasPath(HashMap<String, List<String>> graph, String src, String dest,
            HashSet<String> visited) {
        if (src == dest)
            return true;

        if (visited.contains(src))
            return false;

        visited.add(src);

        for (String neighbour : graph.get(src)) {
            if (hasPath(graph, neighbour, dest, visited))
                return true;
        }

        return false;
    }
}
