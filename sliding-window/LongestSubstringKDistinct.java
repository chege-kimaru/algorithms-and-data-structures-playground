import java.util.*;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aababc", 2));
    }

    public static int longestkSubstr(String s, int k) {
        int maxLength = 0;

        // store the character frequency in window
        HashMap<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Character currChar = s.charAt(windowEnd);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);

            // window can only have a max of k distinct values (map entries or keys)
            while (map.size() > k) {
                Character startChar = s.charAt(windowStart);
                map.put(startChar, map.getOrDefault(startChar, 1) - 1);

                // if the undistinct no longer exists in the window. remove it
                if (map.getOrDefault(startChar, 0) == 0) {
                    map.remove(startChar);
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return map.size() < k ? -1 : maxLength;
    }
}