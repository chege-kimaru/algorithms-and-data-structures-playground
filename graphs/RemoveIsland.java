package graphs;

import java.util.ArrayList;

public class RemoveIsland {
    public static void main(String[] args) {
        // Remove island if not a border island
        int matrix[][] = {
                { 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 1, 0 },
                { 1, 1, 0, 0, 1, 0 },
                { 1, 0, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 1 },
        };

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    ArrayList<Node> explored = new ArrayList<>();
                    boolean a = explore(matrix, i, j, visited, explored);
                    if (!a) {
                        for (Node node : explored) {
                            matrix[node.i][node.j] = 0;
                        }
                    }
                }
            }
        }

        printArray(matrix);
    }

    private static boolean explore(int[][] matrix, int i, int j, boolean[][] visited, ArrayList<Node> explored) {
        if (i < 0 || i >= matrix.length)
            return false;

        if (j < 0 || j >= matrix[i].length)
            return false;

        if (visited[i][j])
            return false;

        if (matrix[i][j] != 1)
            return false;

        visited[i][j] = true;

        explored.add(new Node(i, j));

        boolean isBorder = i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1;

        isBorder = isBorder || explore(matrix, i - 1, j, visited, explored);
        isBorder = isBorder || explore(matrix, i + 1, j, visited, explored);
        isBorder = isBorder || explore(matrix, i, j - 1, visited, explored);
        isBorder = isBorder || explore(matrix, i, j + 1, visited, explored);

        return isBorder;
    }

    private static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
