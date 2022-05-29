package algo.ds.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FenwickTree2dSumTest {

    @Test
    public void test() {
        FenwickTree2dSum t = new FenwickTree2dSum();

        int[][] a = new int[][] {
                {1, 3, -2, 8, -7},
                {5, -5, 6, -1, 3},
                {-1, 2, -2, -6, 5}};
        t.build(a);

        Assertions.assertEquals(1, t.sum(0, 0));
        Assertions.assertEquals(10, t.sum(0, 3));
        Assertions.assertEquals(5, t.sum(2, 0));
        Assertions.assertEquals(4, t.sum(1, 1));
        Assertions.assertEquals(15, t.sum(1, 3));

        // {0, 3, -2, 8, -7},
        // {5, 2, 6, -1, 3},
        // {-1, 2, -2, -6, 5}
        t.inc(0, 0, -1);
        t.inc(1, 1, 7);

        Assertions.assertEquals(0, t.sum(0, 0));
        Assertions.assertEquals(9, t.sum(0, 3));
        Assertions.assertEquals(4, t.sum(2, 0));
        Assertions.assertEquals(10, t.sum(1, 1));
        Assertions.assertEquals(21, t.sum(1, 3));
    }

}
