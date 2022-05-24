package graphs;

import java.util.*;

public class HasPath {
    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        graph.put("f", Arrays.asList("g", "i"));
        graph.put("g", Arrays.asList("h"));
        graph.put("h", new ArrayList<>());
        graph.put("i", Arrays.asList("g", "k"));
        graph.put("j", Arrays.asList("i"));
        graph.put("k", new ArrayList<>());

        // System.out.println(hasPathDF(graph, "f", "k"));
        System.out.println(hasPathBF(graph, "f", "k"));
    }

    private static boolean hasPathDF(HashMap<String, List<String>> graph, String src, String dest) {
        if (src == dest)
            return true;

        for (String neighbour : graph.get(src)) {
            if (hasPathDF(graph, neighbour, dest))
                return true;
        }

        return false;
    }

    private static boolean hasPathBF(HashMap<String, List<String>> graph, String src, String dest) {
        Queue<String> queue = new LinkedList<>();
        queue.add(src);

        while (queue.size() > 0) {
            String current = queue.poll();

            if (current == dest)
                return true;

            for (String neighbour : graph.get(current)) {
                queue.add(neighbour);
            }
        }

        return false;
    }
}
