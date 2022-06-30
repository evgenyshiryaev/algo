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
            sortTest(Sort::insertionSort, Arrays.copyOf(arr, arr.length));
            sortTest(Sort::mergeSort, Arrays.copyOf(arr, arr.length));
            sortTest(Sort::countSort, Arrays.copyOf(arr, arr.length));
            sortTest(Sort::quickSort, Arrays.copyOf(arr, arr.length));
        }
    }


    private static void sortTest(Consumer<int[]> sort, int[] arr) {
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        sort.accept(arr);

        Assertions.assertArrayEquals(expected, arr);
    }


    @Test
    public void quickSelectTest() {
        int[] arr = {1, -10, 66, -159, 588, 29};

        Assertions.assertEquals(-159, Sort.quickSelect(arr, 0));
        Assertions.assertEquals(-10, Sort.quickSelect(arr, 1));
        Assertions.assertEquals(1, Sort.quickSelect(arr, 2));
        Assertions.assertEquals(29, Sort.quickSelect(arr, 3));
        Assertions.assertEquals(66, Sort.quickSelect(arr, 4));
        Assertions.assertEquals(588, Sort.quickSelect(arr, 5));
    }

}
