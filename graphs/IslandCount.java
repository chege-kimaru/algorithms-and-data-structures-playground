package graphs;

import java.util.*;

public class IslandCount {
    public static void main(String[] args) {
        String[][] grid = {
                { "W", "L", "W", "W", "W" },
                { "W", "L", "W", "W", "W" },
                { "W", "W", "W", "L", "W" },
                { "W", "W", "L", "L", "W" },
                { "L", "W", "W", "L", "L" },
                { "L", "L", "W", "W", "W" },
        };

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // HashSet<String> visited = new Hashset<>();
        // Usage visited.add(i + "," j); eg 3,4

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == "L" && !visited[i][j]) {
                    explore(grid, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void explore(String[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0)
            return;
        if (row >= grid.length || col >= grid[row].length)
            return;
        if (visited[row][col])
            return;

        if (grid[row][col] == "W")
            return;

        visited[row][col] = true;

        explore(grid, row - 1, col, visited);
        explore(grid, row + 1, col, visited);
        explore(grid, row, col + 1, visited);
        explore(grid, row, col - 1, visited);
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
