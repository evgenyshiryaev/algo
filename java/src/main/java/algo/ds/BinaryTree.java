package algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class BinaryTree {

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }


    public static List<Integer> preorder(Node root) {
        // TODO
        return null;
    }


    public static List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Node node = root;
        Deque<Node> stack = new ArrayDeque<>();
        while (node.left != null) {
            stack.addLast(node);
            node = node.left;
        }

        while (node != null) {
            result.add(node.val);

            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    stack.addLast(node);
                    node = node.left;
                }
            } else {
                node = stack.pollLast();
            }
        }

        return result;
    }


    public static List<Integer> postorder(Node root) {
        // TODO
        return null;
    }

}
