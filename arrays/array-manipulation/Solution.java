
// https://www.hackerrank.com/challenges/crush/problem
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] queries = {
                { 1, 2, 100 },
                { 2, 5, 100 },
                { 3, 4, 100 },
        };

        System.out.println(arrayManipulation1(10, queries));
    }

    private static long arrayManipulation1(int n, int[][] queries) {
        long[] result = new long[n];

        for (int[] row : queries) {
            int a = row[0] - 1;
            int b = row[1] - 1;
            int k = row[2];

            result[a] += k;
            if (b + 1 < n)
                result[b + 1] -= k;
        }

        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += result[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    // This will exceed time limit
    private static long arrayManipulation2(int n, int[][] queries) {
        long max = Long.MIN_VALUE;

        long[] result = new long[n];

        for (int[] row : queries) {
            int a = row[0] - 1;
            int b = row[1] - 1;
            int k = row[2];

            for (int i = a; i <= b; i++) {
                result[i] += k;
                max = Math.max(max, result[i]);
            }
        }

        return max;
    }

}