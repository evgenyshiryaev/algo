package algo.ds;

import java.util.ArrayList;
import java.util.List;

public class AvlTree {

    private static class Node {
        Node left;
        Node right;

        int val;

        int leftHeight;
        int rightHeight;

        Node(int val) {
            this.val = val;
        }
    }


    private Node root;


    public int height() {
        return root == null ? 0 : Math.max(root.leftHeight, root.rightHeight) + 1;
    }


    private static int height(Node node) {
        return node == null ? 0 : Math.max(node.leftHeight, node.rightHeight) + 1;
    }


    public int heightBruteForce() {
        return heightBruteForce(root);
    }


    private static int heightBruteForce(Node node) {
        return node == null ? 0 : Math.max(heightBruteForce(node.left), heightBruteForce(node.right)) + 1;
    }


    public boolean isBalancedBruteForce() {
        return isBalancedBruteForce(root);
    }


    private static boolean isBalancedBruteForce(Node node) {
        // TODO: refactor
        if (node == null) {
            return true;
        }

        int leftHeight = heightBruteForce(node.left);
        int rightHeight = heightBruteForce(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalancedBruteForce(node.left) && isBalancedBruteForce(node.right);
    }


    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }


    public void insert(int val) {
        root = insert(val, root);
    }

    private static Node insert(int val, Node node) {
        // insert
        if (node == null) {
            return new Node(val);
        }
        if (val == node.val) {
            return node;
        }

        if (val < node.val) {
            node.left = insert(val, node.left);
        } else {
            node.right = insert(val, node.right);
        }

        // balance
        node.leftHeight = height(node.left);
        node.rightHeight = height(node.right);

        // rotate left
        if (node.leftHeight + 1 < node.rightHeight) {
            if (height(node.right.left) > height(node.right.right)) {
                node.right = rotateRight(node.right);
                node.rightHeight = height(node.right);
            }
            return rotateLeft(node);
        }

        // rotate right
        if (node.rightHeight + 1 < node.leftHeight) {
            if (height(node.left.right) > height(node.left.left)) {
                node.left = rotateLeft(node.left);
                node.leftHeight = height(node.left);
            }
            return rotateRight(node);
        }

        return node;
    }


    private static Node rotateLeft(Node node) {
//        System.out.println("rotate left for " + node.val);
        Node right = node.right;
        node.right = right.left;
        right.left = node;

        node.rightHeight = height(node.right);
        right.leftHeight = height(right.left);

        return right;
    }


    private static Node rotateRight(Node node) {
//        System.out.println("rotate right for " + node.val);
        Node left = node.left;
        node.left = left.right;
        left.right = node;

        node.leftHeight = height(node.left);
        left.rightHeight = height(left.right);

        return left;
    }

}
