package algo.ds.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FenwickTree1dTest {

    private static final int[] ARRAY = new int[] {1, 3, -2, 8, -7};


    @Test
    public void sumTest() {
        FenwickTree1d tree = new FenwickTree1d(FenwickTree1d.Type.SUM, ARRAY);

        Assertions.assertEquals(1, tree.sum(0, 0));
        Assertions.assertEquals(-2, tree.sum(2, 2));
        Assertions.assertEquals(-7, tree.sum(4, 4));
        Assertions.assertEquals(4, tree.sum(0, 1));
        Assertions.assertEquals(1, tree.sum(1, 2));
        Assertions.assertEquals(9, tree.sum(1, 3));
        Assertions.assertEquals(3, tree.sum(0, 4));

        tree.update(2, -3);

        Assertions.assertEquals(1, tree.sum(0, 0));
        Assertions.assertEquals(-5, tree.sum(2, 2));
        Assertions.assertEquals(-7, tree.sum(4, 4));
        Assertions.assertEquals(4, tree.sum(0, 1));
        Assertions.assertEquals(-2, tree.sum(1, 2));
        Assertions.assertEquals(6, tree.sum(1, 3));
        Assertions.assertEquals(0, tree.sum(0, 4));
    }


    @Test
    public void minTest() {
        FenwickTree1d tree = new FenwickTree1d(FenwickTree1d.Type.MIN, ARRAY);

        Assertions.assertEquals(1, tree.min(0));
        Assertions.assertEquals(1, tree.min(1));
        Assertions.assertEquals(-2, tree.min(2));
        Assertions.assertEquals(-2, tree.min(3));
        Assertions.assertEquals(-7, tree.min(4));

        tree.update(1, 0);
        tree.update(3, -3);

        Assertions.assertEquals(1, tree.min(0));
        Assertions.assertEquals(0, tree.min(1));
        Assertions.assertEquals(-2, tree.min(2));
        Assertions.assertEquals(-3, tree.min(3));
        Assertions.assertEquals(-7, tree.min(4));
    }


    @Test
    public void maxTest() {
        FenwickTree1d tree = new FenwickTree1d(FenwickTree1d.Type.MAX, ARRAY);

        Assertions.assertEquals(1, tree.max(0));
        Assertions.assertEquals(3, tree.max(1));
        Assertions.assertEquals(3, tree.max(2));
        Assertions.assertEquals(8, tree.max(3));
        Assertions.assertEquals(8, tree.max(4));

        tree.update(0, 4);
        tree.update(4, 10);

        Assertions.assertEquals(4, tree.max(0));
        Assertions.assertEquals(4, tree.max(1));
        Assertions.assertEquals(4, tree.max(2));
        Assertions.assertEquals(8, tree.max(3));
        Assertions.assertEquals(10, tree.max(4));
    }

}
