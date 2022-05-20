package graphs;

import java.util.*;

public class Traversal {

    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        graph.put("a", Arrays.asList("b", "c"));
        graph.put("b", Arrays.asList("d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("f"));
        graph.put("e", new ArrayList<>());
        graph.put("f", new ArrayList<>());

        // depthFirstPrint(graph, "a");
        // depthFirstRecursivePrint(graph, "a");
        breadthFirstPrint(graph, "a");

    }

    private static void depthFirstPrint(HashMap<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while (!stack.empty()) {
            String current = stack.pop();
            System.out.println(current);

            for (String neighbour : graph.get(current)) {
                stack.push(neighbour);
            }
        }
    }

    private static void depthFirstRecursivePrint(HashMap<String, List<String>> graph, String source) {
        System.out.println(source);

        for (String neighbour : graph.get(source)) {
            depthFirstRecursivePrint(graph, neighbour);
        }
    }

    private static void breadthFirstPrint(HashMap<String, List<String>> graph, String source) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);

        while (queue.size() > 0) {
            String current = queue.poll();
            System.out.println(current);

            for (String neighbour : graph.get(current)) {
                queue.add(neighbour);
            }
        }
    }
}