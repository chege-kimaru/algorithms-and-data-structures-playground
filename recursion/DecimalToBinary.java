package recursion;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(toBinary(60, ""));
    }

    private static String toBinary(int decimal, String result) {
        if (decimal == 0)
            return result;

        result = decimal % 2 + result;

        return toBinary(decimal / 2, result);
    }
}
