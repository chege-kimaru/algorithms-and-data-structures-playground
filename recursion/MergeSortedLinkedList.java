package recursion;

public class MergeSortedLinkedList {
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Node a5 = new Node(110);
        Node a4 = new Node(90, a5);
        Node a3 = new Node(52, a4);
        Node a2 = new Node(47, a3);
        Node a1 = new Node(22, a2);

        Node b7 = new Node(137);
        Node b6 = new Node(130, b7);
        Node b5 = new Node(115, b6);
        Node b4 = new Node(78, b5);
        Node b3 = new Node(52, b4);
        Node b2 = new Node(18, b3);
        Node b1 = new Node(9, b2);

        printLinkedlIst(a1);
        printLinkedlIst(b1);
        printLinkedlIst(sortedMerge(a1, b1));
    }

    private static Node sortedMerge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.val <= b.val) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            return b;
        }
    }

    private static void printLinkedlIst(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }

        System.out.println();
    }
}
