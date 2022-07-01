package recursion;

import java.util.List;

public class BSTPrintLeafNodes {
    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(100, 80, 120, 65, 95, 115, 140, 45);

        Node root = null;
        for (int num : nums) {
            root = insertNode(root, num);
        }

        printLeaves(root);
    }

    private static void printLeaves(Node root) {
        if (root == null)
            return;

        // check if leaf
        if (root.left == null && root.left == null) {
            System.out.print(root.val + "\t");
            return;
        }

        if (root.left != null)
            printLeaves(root.left);
        if (root.right != null)
            printLeaves(root.right);
    }

    private static Node insertNode(Node root, int val) {
        // insertion happens at the leaf
        if (root == null) {
            Node node = new Node(val);
            return node;
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }

        return root;
    }
}
