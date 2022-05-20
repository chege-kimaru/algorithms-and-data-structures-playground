package toptal;

public class Test {
    public static void main(String[] args) {
        System.out.println(String.valueOf(numberOfCarryOperations(55, 29)));
        System.out.println(String.valueOf(numberOfCarryOperations(1, 999999)));
        System.out.println(String.valueOf(numberOfCarryOperations(10, 90)));
        System.out.println(String.valueOf(numberOfCarryOperations(15, 8)));
        System.out.println(String.valueOf(numberOfCarryOperations(13, 4)));
    }

    private static int numberOfCarryOperations(int num1, int num2) {
        // convert nums into a string
        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);

        int totalCarry = 0;
        // loop length
        int len = Math.max(num1Str.length(), num2Str.length());
        // num1 counter
        int x = num1Str.length() - 1;
        // num2 counter
        int y = num2Str.length() - 1;
        int a = 0, b = 0;
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (x >= 0)
                a = Integer.valueOf(String.valueOf(num1Str.charAt(x)));
            if (y >= 0)
                b = Integer.valueOf(String.valueOf(num2Str.charAt(y)));

            carry = (a + b + carry) / 10;
            if (carry >= 1)
                totalCarry++;

            x--;
            y--;
        }

        return totalCarry;
    }
}
