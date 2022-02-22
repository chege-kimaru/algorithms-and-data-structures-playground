//https://gist.github.com/Schachte/87d7c0165a584f26b3ad7845f8010387
/**
 * Find the max sum subarray of a fixed size K
 *
 * Example input:
 * [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
 *
 */
public class MaxSumSubarray {

    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;

        // int windowStart = 0;
        // for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        // runningSum += arr[windowEnd];

        // if (windowEnd - windowStart + 1 == k) {
        // maxSum = Math.max(maxSum, runningSum);
        // runningSum -= arr[windowStart];
        // windowStart++;
        // }
        // }

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, runningSum);
                runningSum -= arr[i - (k - 1)];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubarray(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3));
    }
}