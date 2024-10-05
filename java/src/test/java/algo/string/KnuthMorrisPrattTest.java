package algo.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class KnuthMorrisPrattTest {

    private static final String[][] FIND_STRINGS = {
            {"dummy", ""}, {"dummy", "dum"}, {"dummy", "um"}, {"dummy", "my"}, {"dummy", "m"},
            {"SuperLongString", "erLo"}, {"SuperLongString", "ong"}, {"SuperLongString", "long"},
            {"aabcabdabcbcabcc", "abc"}};
    private static final int[][] FIND_RESULTS = {
            {}, {0}, {1}, {3}, {2, 3},
            {3}, {6}, {},
            {1, 7, 12}};

    @Test
    public void getPrefixFunctionTest() {
        Assertions.assertArrayEquals(new int[] {}, KnuthMorrisPratt.getPrefixFunction(""));
        Assertions.assertArrayEquals(new int[] {0}, KnuthMorrisPratt.getPrefixFunction("a"));
        Assertions.assertArrayEquals(new int[] {0, 0}, KnuthMorrisPratt.getPrefixFunction("ab"));
        Assertions.assertArrayEquals(new int[] {0, 1}, KnuthMorrisPratt.getPrefixFunction("aa"));
        Assertions.assertArrayEquals(new int[] {0, 0, 0, 1, 2, 3, 0}, KnuthMorrisPratt.getPrefixFunction("abcabcd"));
        Assertions.assertArrayEquals(new int[] {0, 1, 0, 1, 2, 2, 3}, KnuthMorrisPratt.getPrefixFunction("aabaaab"));
    }

    @Test
    public void findTest() {
        for (int i = 0; i < FIND_STRINGS.length; ++ i) {
            Assertions.assertArrayEquals(FIND_RESULTS[i], KnuthMorrisPratt.find0(FIND_STRINGS[i][0], FIND_STRINGS[i][1]));
            Assertions.assertArrayEquals(FIND_RESULTS[i], KnuthMorrisPratt.find1(FIND_STRINGS[i][0], FIND_STRINGS[i][1]));
        }
    }

}
