package algo;

import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SortTest {

    private static final int[][] ARRAYS = {
            {},
            {10},
            {1, 2, 3},
            {-1, -2, -3},
            {1, -10, 66, -159, 588, 29}
    };


    @Test
    public void allSortsTest() {
        for (int[] arr : ARRAYS) {
            test(Sort::insertionSort, Arrays.copyOf(arr, arr.length));
            test(Sort::mergeSort, Arrays.copyOf(arr, arr.length));
            test(Sort::countSort, Arrays.copyOf(arr, arr.length));
        }
    }


    private static void test(Consumer<int[]> sort, int[] arr) {
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        sort.accept(arr);

        Assertions.assertArrayEquals(expected, arr);
    }

}
