package recursion;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(recursiveSummation(5));
    }

    private static int recursiveSummation(int n) {
        if (n <= 1)
            return n;
        return n + recursiveSummation(n - 1);
    }
}