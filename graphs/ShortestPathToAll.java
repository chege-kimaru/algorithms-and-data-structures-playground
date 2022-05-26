package graphs;

import java.util.*;

//https://www.hackerrank.com/challenges/bfsshortreach/problem
/**
 * Consider an undirected graph where each edge weighs 6 units. Each of the
 * nodes is labeled consecutively from 1 to n.
 * 
 * You will be given a number of queries. For each query, you will be given a
 * list of edges describing an undirected graph. After you create a
 * representation of the graph, you must determine and report the shortest
 * distance to each of the other nodes from a given starting position using the
 * breadth-first search algorithm (BFS). Return an array of distances from the
 * start node in node number order. If a node is unreachable, return for that
 * node.
 */

public class ShortestPathToAll {
    public static void main(String[] args) {
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3));
        System.out.println(bfs(4, 2, edges, 1));
    }

    private static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Graph can be List<List<Integer>>
        // or Map<Integer, List<Integer>>
        // or int[][]
        // any will work
        int[][] graph = buildGraph(edges, n);

        int[] shortestDistances = shortestPath(graph, s);

        ArrayList<Integer> distances = new ArrayList<>();
        for (int i = 1; i < graph.length; i++) {
            if (i == s)
                continue;
            distances.add(shortestDistances[i]);
        }
        return distances;
    }

    private static int[][] buildGraph(List<List<Integer>> edges, int n) {
        int[][] graph = new int[n + 1][n + 1];

        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        return graph;
    }

    private static int[] shortestPath(
            int[][] graph,
            int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        int[] distances = new int[graph.length];
        Arrays.fill(distances, -1);
        distances[source] = 0;

        while (queue.size() > 0) {
            int current = queue.poll();

            for (int neighbour = 1; neighbour < graph[current].length; neighbour++) {
                if (graph[current][neighbour] != 1)
                    continue;

                if (distances[neighbour] != -1)
                    continue;

                queue.add(neighbour);

                distances[neighbour] = distances[current] + 6;
            }
        }

        return distances;
    }
}
