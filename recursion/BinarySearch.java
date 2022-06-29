package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 9, 12, 17, 22, 56, 89, 145 };
        System.out.println(binarySearch(arr, 0, arr.length - 1, 89));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1));
    }

    private static int binarySearch(int[] arr, int left, int right, int x) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == x)
            return mid;
        else if (arr[mid] > x)
            return binarySearch(arr, left, mid - 1, x);
        else
            return binarySearch(arr, mid + 1, right, x);
    }
}
