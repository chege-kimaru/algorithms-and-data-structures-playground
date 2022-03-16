// https://www.hackerrank.com/challenges/array-left-rotation/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        arr = rotateLeft(arr, arr.length, 4);

        System.out.println(Arrays.toString(arr));
    }

    private static int[] rotateLeft(int[] arr, int n, int d) {
        d = d % n;

        int moves = 0;
        int i = 0;

        while (moves < n) {
            int j = i;

            int prev = arr[j];
            while (true) {
                j = j - d;
                if (j < 0)
                    j = n + j;

                int temp = arr[j];
                arr[j] = prev;
                prev = temp;

                moves++;

                if (j == i)
                    break;
            }

            i++;
        }

        return arr;
    }
}