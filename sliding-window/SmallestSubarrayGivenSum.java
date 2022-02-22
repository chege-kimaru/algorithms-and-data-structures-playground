//https://gist.github.com/Schachte/87d7c0165a584f26b3ad7845f8010387

public class SmallestSubarrayGivenSum {

    public static int smallestSubarray(int targetSum, int[] arr) {
        int smallestSubarray = Integer.MAX_VALUE;

        int runningSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            runningSum += arr[windowEnd];

            while (runningSum >= targetSum) {
                if (runningSum == targetSum)
                    smallestSubarray = Math.min(smallestSubarray, windowEnd - windowStart + 1);
                runningSum -= arr[windowStart];
                windowStart++;
            }
        }

        return smallestSubarray;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 4, 2, 7, 7, 6, 2, 2, 1, 10 };
        int targetSum = 8;
        System.out.println(smallestSubarray(targetSum, input));
    }
}