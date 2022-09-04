package algo.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonotonicStackTest {

    @Test
    public void getRightGreatersTest() {
        Assertions.assertArrayEquals(
                new int[] {-1, 2, 7, 4, 7, 6, 7, -1},
                MonotonicStack.getRightGreaters(new int[] {10, 1, 6, 2, 4, 1, 4, 9}));
    }


    @Test
    public void getIntervalMaxsTest() {
        Assertions.assertArrayEquals(
                new int[] {10, 1, 6, 2, 4, 1, 4, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 1));
        Assertions.assertArrayEquals(
                new int[] {10, 6, 6, 4, 4, 4, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 2));
        Assertions.assertArrayEquals(
                new int[] {10, 6, 6, 4, 4, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 3));
        Assertions.assertArrayEquals(
                new int[] {10, 6, 6, 4, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 4));
        Assertions.assertArrayEquals(
                new int[] {10, 6, 6, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 5));
        Assertions.assertArrayEquals(
                new int[] {10, 6, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 6));
        Assertions.assertArrayEquals(
                new int[] {10, 9},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 7));
        Assertions.assertArrayEquals(
                new int[] {10},
                MonotonicStack.getIntervalMaxs(new int[] {10, 1, 6, 2, 4, 1, 4, 9}, 8));
    }

}
