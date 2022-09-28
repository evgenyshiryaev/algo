package algo.utils;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UtilsTest {

    @Test
    public void toArrayTest() {
        List<Integer> list = Arrays.asList(5, 55, -40, 444);
        Assertions.assertArrayEquals(new int[] {5, 55, -40, 444}, Utils.toArray(list));
    }


    @Test
    public void printTest() {
        Utils.print(List.of(new int[] {1, 2, 3}, new int[] {10, 9}));
    }

}
