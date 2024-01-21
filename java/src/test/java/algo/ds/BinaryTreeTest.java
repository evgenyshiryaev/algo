package algo.ds;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import algo.ds.BinaryTree.Node;


public class BinaryTreeTest {

    @Test
    public void inorderTest() {
        Assertions.assertEquals(
                List.of(11, 8, 1, 17, 10, 20, 15, 6),
                BinaryTree.inorder(getTree()));
    }


    private static Node getTree() {
        Node root = new Node(10);

        Node left0 = new Node(8);
        root.left = left0;

        Node left1 = new Node(11);
        left0.left = left1;

        Node left2 = new Node(17);
        left0.right = left2;

        Node left3 = new Node(1);
        left2.left = left3;

        Node right0 = new Node(20);
        root.right = right0;

        Node right1 = new Node(6);
        right0.right = right1;

        Node right2 = new Node(15);
        right1.left = right2;

        return root;
    }

}
