package graphs;

import java.util.*;

public class MinimumIsland {
    public static void main(String[] args) {
        String[][] grid = {
                { "W", "L", "W", "W", "W" },
                { "W", "L", "W", "W", "W" },
                { "W", "W", "W", "L", "W" },
                { "W", "W", "L", "L", "W" },
                { "L", "W", "W", "L", "L" },
                { "L", "L", "W", "W", "W" },
        };

        int smallest = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // HashSet<String> visited = new Hashset<>();
        // Usage visited.add(i + "," j); eg 3,4

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == "L" && !visited[i][j]) {
                    int size = exploreSize(grid, i, j, visited);
                    smallest = Math.min(smallest, size);
                }
            }
        }

        System.out.println(smallest);
    }

    private static int exploreSize(String[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0)
            return 0;
        if (row >= grid.length || col >= grid[row].length)
            return 0;
        if (visited[row][col])
            return 0;
        if (grid[row][col] == "W")
            return 0;

        visited[row][col] = true;

        int size = 1;

        size += exploreSize(grid, row - 1, col, visited);
        size += exploreSize(grid, row + 1, col, visited);
        size += exploreSize(grid, row, col + 1, visited);
        size += exploreSize(grid, row, col - 1, visited);

        return size;
    }

    static void printArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
