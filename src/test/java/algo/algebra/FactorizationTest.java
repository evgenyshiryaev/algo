package algo.algebra;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FactorizationTest {

    private static final Map<Integer, List<Integer>> INPUT = Map.of(
            2, Arrays.asList(2),
            3, Arrays.asList(3),
            4, Arrays.asList(2, 2),
            220, Arrays.asList(2, 2, 5, 11));


    @Test
    public void factorizationTest() {
        for (var input : INPUT.entrySet()) {
            doTest(input.getKey(), input.getValue());
        }
    }


    private static void doTest(int n, List<Integer> expected) {
        Assertions.assertEquals(expected, Factorization.trialDivision(n));
        Assertions.assertEquals(expected, Factorization.primeDivision(n));
    }

}
