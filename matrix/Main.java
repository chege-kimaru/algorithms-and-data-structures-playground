public class Main {

    public static void main(String[] args) {
        // int[][] matrix = {
        // { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 }
        // };

        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd) {

            // print the top side
            int tempRow = rowStart;
            int tempColumn = columnStart;
            while (tempColumn <= columnEnd && rowStart <= rowEnd) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempColumn++;
            }
            rowStart++;

            // print The right side
            tempRow = rowStart;
            tempColumn = columnEnd;
            while (tempRow <= rowEnd && columnStart <= columnEnd) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempRow++;
            }
            columnEnd--;

            // print the bottom side
            tempRow = rowEnd;
            tempColumn = columnEnd;
            while (tempColumn >= columnStart && rowStart <= rowEnd) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempColumn--;
            }
            rowEnd--;

            // print the left side
            tempRow = rowEnd;
            tempColumn = columnStart;
            while (tempRow >= rowStart && columnStart <= columnEnd) {
                System.out.print(matrix[tempRow][tempColumn] + " ");
                tempRow--;
            }
            columnStart++;
        }
    }
}
