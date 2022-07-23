package algo.string;

import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import algo.utils.Pair;


public class PalindromeTest {

    private static final List<Pair<String, int[][]>> DATA = List.of(
            new Pair<>("", new int[][] {{}, {}}),
            new Pair<>("a", new int[][] {{1}, {0}}),
            new Pair<>("aa", new int[][] {{1, 1}, {0, 1}}),
            new Pair<>("ab", new int[][] {{1, 1}, {0, 0}}),
            new Pair<>("aba", new int[][] {{1, 2, 1}, {0, 0, 0}}),
            new Pair<>("abc", new int[][] {{1, 1, 1}, {0, 0, 0}}),
            new Pair<>("abba", new int[][] {{1, 1, 1, 1}, {0, 0, 2, 0}}),
            new Pair<>("abababc", new int[][] {{1, 2, 3, 3, 2, 1, 1}, {0, 0, 0, 0, 0, 0, 0}}),
            new Pair<>("cbaabd", new int[][] {{1, 1, 1, 1, 1, 1}, {0, 0, 0, 2, 0, 0}})
            );


    @Test
    public void palindromeTest() {
        for (Pair<String, int[][]> pair : DATA) {
            palindromeTest(Palindrome::countN2, pair.a, pair.b);
            palindromeTest(Palindrome::manacher, pair.a, pair.b);
        }
    }


    private static void palindromeTest(Function<String, int[][]> f, String s, int[][] d) {
        deepAssertArrayEqueals(d, f.apply(s));
    }


    private static void deepAssertArrayEqueals(int[][] expected, int[][] actual) {
        Assertions.assertEquals(2, actual.length);
        Assertions.assertArrayEquals(expected[0], actual[0]);
        Assertions.assertArrayEquals(expected[1], actual[1]);
    }

}
