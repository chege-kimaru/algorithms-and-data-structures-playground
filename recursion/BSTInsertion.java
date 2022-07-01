package recursion;

public class BSTInsertion {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(100);
        Node n2 = new Node(80);
        Node n3 = new Node(120);
        Node n4 = new Node(65);
        Node n5 = new Node(95);
        Node n6 = new Node(115);
        Node n7 = new Node(140);
        Node n8 = new Node(45);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;

        /*
         * 100
         * / \
         * 80 120
         * / \ / \
         * 65 95 115 140
         * /
         * 45
         * 
         */

        System.out.println("Before insertion");
        System.out.println(n7.left != null ? n7.left.val : null);
        System.out.println(n7.right != null ? n7.right.val : null);
        insert(n1, 122);
        System.out.println("After insertion");
        System.out.println(n7.left != null ? n7.left.val : null);
        System.out.println(n7.right != null ? n7.right.val : null);
    }

    private static Node insert(Node root, int val) {
        // insertion happens at the leaf
        if (root == null) {
            Node node = new Node(val);
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }
}
