package algo;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSortTest {

    @Test
    public void test() {
        int[] arr = new int[] {1, -10, 66, -159, 588, 29};

        CountSort.countSort(arr);

        for (int i = 1; i < arr.length; ++ i) {
            Assertions.assertTrue(arr[i] >= arr[i - 1], Arrays.toString(arr));
        }
    }

}
