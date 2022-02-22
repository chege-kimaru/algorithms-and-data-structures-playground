class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class SinglyLinkedList {
    public void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + "\t");
            current = current.next;
        }
        System.out.println();
    }

    public Node zippedNodes(Node head1, Node head2) {
        // return zippedNodesRecursive(head1, head2);
        return zippedNodesIterative(head1, head2);
    }

    private Node zippedNodesRecursive(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node next = head1.next;
        head1.next = head2;
        head2.next = zippedNodesRecursive(next, head2.next);

        return head1;
    }

    private Node zippedNodesIterative(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        int count = 0;

        Node tail = head1;
        Node current1 = head1.next;
        Node current2 = head2;

        while (current1 != null && current2 != null) {
            if (count % 2 == 0) {
                tail.next = current2;
                current2 = current2.next;
            } else {
                tail.next = current1;
                current1 = current1.next;
            }
            tail = tail.next;
            count++;
        }

        if (current1 != null)
            tail.next = current1;
        if (current2 != null)
            tail.next = current2;

        return head1;
    }
}

public class Main {
    public static void main(String[] args) {

        Node a1 = new Node(4);
        Node a2 = new Node(7);
        Node a3 = new Node(2);
        Node a4 = new Node(5);
        Node a5 = new Node(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        Node b1 = new Node(3);
        Node b2 = new Node(8);
        Node b3 = new Node(1);
        b1.next = b2;
        b2.next = b3;

        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.print(a1);
        linkedList.print(b1);

        System.out.println("Zipped");
        linkedList.print(linkedList.zippedNodes(a1, b1));
    }
}
