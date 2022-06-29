package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    // Poor implementation. Just for demo purposes
    private static int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
