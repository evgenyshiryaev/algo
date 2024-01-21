package algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrefixSumTest {

    @Test
    public void prefixSum1DTest() {
        int[] nums = {4, -10, 5, 0, 13, -5, 6, -7, -1};
        int[] sums = PrefixSum.prefixSum1D(nums);

        Assertions.assertArrayEquals(new int[] {0, 4, -6, -1, -1, 12, 7, 13, 6, 5}, sums);

        Assertions.assertEquals(4, PrefixSum.getSum1D(sums, 0, 0));
        Assertions.assertEquals(-5, PrefixSum.getSum1D(sums, 5, 5));
        Assertions.assertEquals(-1, PrefixSum.getSum1D(sums, 0, 2));
        Assertions.assertEquals(13, PrefixSum.getSum1D(sums, 2, 5));
    }


    @Test
    public void prefixSum2DTest() {
        int[][] nums = {
                {2, -7, 11, 1},
                {-11, 0, 2, -4},
                {4, 4, -7, 1},
                {-9, -7, 2, 5}
        };
        int[][] sums = PrefixSum.prefixSum2D(nums);

        Assertions.assertEquals(2, PrefixSum.getSum2D(sums, 0, 0, 0, 0));
        Assertions.assertEquals(-4, PrefixSum.getSum2D(sums, 1, 3, 1, 3));
        Assertions.assertEquals(-1, PrefixSum.getSum2D(sums, 1, 1, 2, 2));
        Assertions.assertEquals(-1, PrefixSum.getSum2D(sums, 1, 2, 3, 3));
    }

}
