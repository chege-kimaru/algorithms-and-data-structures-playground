public class Main {
    public static void main(String[] args) {
        TOH(3, 'A', 'B', 'C');
    }

    // n is the number of discs
    static void TOH(int n, char A, char B, char C) {
        if (n > 0) {
            // move n - 1 from A to B using C
            TOH(n - 1, A, C, B);
            System.out.println("Move from " + A + " to " + C);
            // move n - 1 from B to C using A
            TOH(n - 1, B, A, C);
        }
    }
}
