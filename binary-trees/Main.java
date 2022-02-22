import java.util.*;

class Node {
    String val;
    Node left = null;
    Node right = null;

    Node(String val) {
        this.val = val;
    }
}

class NodeInt {
    int val;
    NodeInt left = null;
    NodeInt right = null;

    NodeInt(int val) {
        this.val = val;
    }
}

class BinaryTree {

    public String[] traverse(Node root) {
        // return traverseDFIterative(root);
        // return traverseDFRecursive(root);
        return traverseBF(root);
    }

    public boolean includes(Node root, String target) {
        // return includesDFRecursive(root, target);
        return includesBFIterative(root, target);
    }

    public int sum(NodeInt root) {
        // return sumDFRecursive(root);
        return sumBFIterative(root);
    }

    public int minValue(NodeInt root) {
        // return minValueDFRecursive(root);
        return minValueBFIterative(root);
    }

    public int maxPathSum(NodeInt root) {
        return maxPathSumDFRecursive(root);
    }

    private int maxPathSumDFRecursive(NodeInt root) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.left == null && root.right == null)
            return root.val;
        return root.val +
                Math.max(maxPathSumDFRecursive(root.left),
                        maxPathSumDFRecursive(root.right));
    }

    private int minValueDFRecursive(NodeInt root) {
        if (root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.val,
                Math.min(minValueDFRecursive(root.left),
                        minValueDFRecursive(root.right)));
    }

    private int minValueBFIterative(NodeInt root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        Queue<NodeInt> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            NodeInt current = queue.poll();
            if (current.val < min) {
                min = current.val;
            }

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        return min;
    }

    private int sumDFRecursive(NodeInt root) {
        if (root == null)
            return 0;
        return root.val + sumDFRecursive(root.left) + sumDFRecursive(root.right);
    }

    private int sumBFIterative(NodeInt root) {
        if (root == null)
            return 0;

        int totalSum = 0;
        Queue<NodeInt> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            NodeInt current = queue.poll();
            totalSum += current.val;

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        return totalSum;
    }

    private boolean includesDFRecursive(Node root, String target) {
        if (root == null)
            return false;
        return root.val.equals(target)
                || includesDFRecursive(root.left, target)
                || includesDFRecursive(root.right, target);
    }

    private boolean includesBFIterative(Node root, String target) {
        if (root == null)
            return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.val.equals(target))
                return true;

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        return false;
    }

    private String[] traverseBF(Node root) {
        if (root == null)
            return new String[] {};

        List<String> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.val);

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return result.stream().toArray(String[]::new);
    }

    private String[] traverseDFRecursive(Node root) {
        return traverseDFRecursiveR(root).stream().toArray(String[]::new);
    }

    private List<String> traverseDFRecursiveR(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(traverseDFRecursiveR(root.left));
        list.addAll(traverseDFRecursiveR(root.right));
        return list;
    }

    private String[] traverseDFIterative(Node root) {
        if (root == null)
            return new String[] {};
        List<String> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }

        return result.stream().toArray(String[]::new);
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        // a
        // / \
        // b c
        // / \ \
        // d e f

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        Arrays.stream(tree.traverse(a)).forEach(System.out::println);

        System.out.println();
        System.out.println("Tree includes a: " + tree.includes(a, "a"));

        NodeInt a1 = new NodeInt(5);
        NodeInt b1 = new NodeInt(7);
        NodeInt c1 = new NodeInt(2);
        NodeInt d1 = new NodeInt(4);
        NodeInt e1 = new NodeInt(1);
        NodeInt f1 = new NodeInt(3);

        // 5
        // / \
        // 7 2
        // / \ \
        // 4 1 3

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.right = f1;

        System.out.println();
        System.out.println("Tree sum: " + tree.sum(a1));

        System.out.println();
        System.out.println("Tree min: " + tree.minValue(a1));

        System.out.println();
        System.out.println("Max Path Sum: " + tree.maxPathSum(a1));
    }
}