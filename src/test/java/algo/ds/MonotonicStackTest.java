package algo.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonotonicStackTest {

    @Test
    public void test() {
        Assertions.assertArrayEquals(
                new int[] {-1, 2, 7, 4, 7, 6, 7, -1},
                MonotonicStack.getMax(new int[] {10, 1, 6, 2, 4, 1, 4, 9}));
    }

}
