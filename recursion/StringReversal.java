package recursion;

public class StringReversal {
    public static void main(String[] args) {
        String s = "Kevin";
        System.out.println(reverseString(s));
    }

    private static String reverseString(String s) {
        if (s.isEmpty())
            return "";
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}
