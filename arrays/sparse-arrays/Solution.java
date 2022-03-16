// https://www.hackerrank.com/challenges/sparse-arrays/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] strings = { "ab", "ab", "abc" };
        String[] queries = { "ab", "abc", "bc" };

        int[] result = matchingStrings(strings, queries);
        System.out.println(Arrays.toString(result));
    }

    private static int[] matchingStrings(String[] strings, String[] queries) {
        // Write your code here
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (String s : strings) {
                if (queries[i].equals(s))
                    count++;
            }
            result[i] = count;
        }
        return result;
    }
}