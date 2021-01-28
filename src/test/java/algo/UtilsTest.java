package algo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import algo.utils.Utils;


public class UtilsTest {

    @Test
    public void toArrayTest() {
        List<Integer> list = Arrays.asList(5, 55, -40, 444);
        Assertions.assertArrayEquals(new int[] {5, 55, -40, 444}, Utils.toArray(list));
    }

}
