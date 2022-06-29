package graphs;

/**
 * https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 * The member states of the UN are planning to send 2 people to the moon. 
 * They want them to be from different countries. You will be given a list of pairs of astronaut ID's. 
 * Each pair is made of astronauts from the same country. 
 * Determine how many pairs of astronauts from different countries they can choose from.
 */

import java.util.*;

public class JourneyToTheMoon {
    public static void main(String[] args) {
        // atronauts grouped by country
        List<List<Integer>> astronaut = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(2, 3),
                Arrays.asList(0, 4));
        int n = 5; // number of astronauts

        System.out.println(journeyToMoon(n, astronaut));
    }

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(n, astronaut);
        Set<Integer> visited = new HashSet<>();
        long pairs = 0;
        long curTotal = 0;
        for (int key : graph.keySet()) {
            if (visited.contains(key))
                continue;
            int count = countryGroupSize(key, graph, visited);
            pairs += curTotal * count;
            curTotal += count;
        }
        return pairs;
    }

    private static int countryGroupSize(int i, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        visited.add(i);

        int count = 1;
        for (int neighbour : graph.get(i)) {
            if (!visited.contains(neighbour))
                count += countryGroupSize(neighbour, graph, visited);
        }

        return count;
    }

    private static Map<Integer, Set<Integer>> buildGraph(int n, List<List<Integer>> pairs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }
}
