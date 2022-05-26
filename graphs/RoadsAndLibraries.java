package graphs;

/**
https://www.hackerrank.com/challenges/torque-and-development/problem?isFullScreen=true
Determine the minimum cost to provide library access to all citizens of HackerLand. 
There are n cities numbered from 1 to n. 
Currently there are no libraries and the cities are not connected. 
Bidirectional roads may be built between any city pair listed in . 
A citizen has access to a library if:
- Their city contains a library.
- They can travel by road from their city to a city containing a library.
 */

import java.util.*;

public class RoadsAndLibraries {
    public static void main(String[] args) {
        List<List<Integer>> cities = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 1),
                Arrays.asList(2, 3));
        System.out.println(roadsAndLibraries(3, 2, 1, cities));
    }

    private static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        HashMap<Integer, List<Integer>> graph = buildGraph(cities, n);

        if (c_lib <= c_road)
            return ((long) n * c_lib);

        HashSet<Integer> visited = new HashSet<>();
        long cost = 0;
        for (int city : graph.keySet()) {
            if (visited.contains(city))
                continue;
            cost += c_lib;
            long size = exploreSize(graph, city, visited);
            cost += (size - 1) * c_road;
        }

        return cost;
    }

    private static long exploreSize(HashMap<Integer, List<Integer>> graph, int start, HashSet<Integer> visited) {
        visited.add(start);

        long size = 1;
        for (int neighbour : graph.get(start)) {
            if (!visited.contains(neighbour))
                size += exploreSize(graph, neighbour, visited);
        }

        return size;
    }

    private static HashMap<Integer, List<Integer>> buildGraph(List<List<Integer>> edges, int n) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }
}
