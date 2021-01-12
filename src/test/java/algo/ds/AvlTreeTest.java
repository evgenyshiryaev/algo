package algo.ds;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AvlTreeTest {

    @Test
    public void test() {
        AvlTree tree = new AvlTree();

        Assertions.assertEquals(Arrays.asList(), tree.inOrder());
        Assertions.assertEquals(0, tree.height());
        Assertions.assertEquals(0, tree.heightBruteForce());
        Assertions.assertTrue(tree.isBalancedBruteForce());

        tree.insert(10);
        Assertions.assertEquals(Arrays.asList(10), tree.inOrder());
        Assertions.assertEquals(1, tree.height());
        Assertions.assertEquals(1, tree.heightBruteForce());
        Assertions.assertTrue(tree.isBalancedBruteForce());

        tree.insert(11);
        Assertions.assertEquals(Arrays.asList(10, 11), tree.inOrder());
        Assertions.assertEquals(2, tree.height());
        Assertions.assertEquals(2, tree.heightBruteForce());
        Assertions.assertTrue(tree.isBalancedBruteForce());

        tree.insert(12);
        Assertions.assertEquals(Arrays.asList(10, 11, 12), tree.inOrder());
        Assertions.assertEquals(2, tree.height());
        Assertions.assertEquals(2, tree.heightBruteForce());
        Assertions.assertTrue(tree.isBalancedBruteForce());
    }


    @Test
    public void rotateTest() {
        AvlTree tree = new AvlTree();

        tree.insert(1);
        tree.insert(15);
        tree.insert(14);
        tree.insert(7);
        tree.insert(2);
        tree.insert(3);
        tree.insert(12);
        tree.insert(9);
        tree.insert(11);
        tree.insert(17);

        Assertions.assertEquals(Arrays.asList(1, 2, 3, 7, 9, 11, 12, 14, 15, 17), tree.inOrder());
        Assertions.assertEquals(4, tree.height());
        Assertions.assertEquals(4, tree.heightBruteForce());
        Assertions.assertTrue(tree.isBalancedBruteForce());
    }

}
