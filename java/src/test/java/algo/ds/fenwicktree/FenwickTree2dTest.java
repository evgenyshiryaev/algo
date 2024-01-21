package algo.ds.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FenwickTree2dTest {

    @Test
    public void test() {
        FenwickTree2d tree = new FenwickTree2d();

        int[][] a = new int[][] {
                {1, 3, -2, 8, -7},
                {5, -5, 6, -1, 3},
                {-1, 2, -2, -6, 5}};
        tree.build(a);

        Assertions.assertEquals(1, tree.sum(0, 0));
        Assertions.assertEquals(10, tree.sum(0, 3));
        Assertions.assertEquals(5, tree.sum(2, 0));
        Assertions.assertEquals(4, tree.sum(1, 1));
        Assertions.assertEquals(15, tree.sum(1, 3));

        // {0, 3, -2, 8, -7},
        // {5, 2, 6, -1, 3},
        // {-1, 2, -2, -6, 5}
        tree.inc(0, 0, -1);
        tree.inc(1, 1, 7);

        Assertions.assertEquals(0, tree.sum(0, 0));
        Assertions.assertEquals(9, tree.sum(0, 3));
        Assertions.assertEquals(4, tree.sum(2, 0));
        Assertions.assertEquals(10, tree.sum(1, 1));
        Assertions.assertEquals(21, tree.sum(1, 3));
    }

}
