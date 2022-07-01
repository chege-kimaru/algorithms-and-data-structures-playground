package recursion;

public class ReverseLinkedList {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        printLinkedlIst(a1);
        printLinkedlIst(reverseLinkedList(a1));
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node p = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
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
