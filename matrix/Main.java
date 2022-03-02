public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 9 },
                { 5, 6, 7, 8, 5 },
                { 9, 10, 11, 12, 4 },
                { 13, 14, 15, 16, 11 }
        };

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowStart < rowEnd) {
            // print the top side
            int tempRow = rowStart;
            int tempColumn = columnStart;
            while (tempColumn <= columnEnd) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempColumn++;
            }
            rowStart++;

            // print The right side
            tempRow = rowStart;
            tempColumn = columnEnd;
            while (tempRow <= rowEnd) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempRow++;
            }
            columnEnd--;

            // print the bottom side
            tempRow = rowEnd;
            tempColumn = columnEnd;
            while (tempColumn >= columnStart) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempColumn--;
            }
            rowEnd--;

            // print the left side
            tempRow = rowEnd;
            tempColumn = columnStart;
            while (tempRow >= rowStart) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempRow--;
            }
            columnStart++;
        }
    }
}
