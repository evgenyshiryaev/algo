package algo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import algo.utils.Pair;


public class LISTest {

    private static final List<Pair<int[], int[]>> INPUT = Arrays.asList(
            new Pair<>(new int[] {10,9,2,5,3,7,101,18}, new int[] {2, 3, 7, 18}),
            new Pair<>(new int[] {0,1,0,3,2,3},  new int[] {0, 1, 2, 3}),
            new Pair<>(new int[] {7,7,7,7,7,7,7}, new int[] {7}));


    @Test
    public void lisN2Test() {
        test(LIS::lisN2);
        test(LIS::lisNlogN);
    }


    private static void test(Function<int[], int[]> lis) {
        for (var input : INPUT) {
            Assertions.assertArrayEquals(input.b, lis.apply(input.a));
        }
    }

}
