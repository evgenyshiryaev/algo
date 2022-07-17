package algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnuthMorrisPrattTest {

    @Test
    public void findTest() {
        Assertions.assertArrayEquals(new int[] {}, KnuthMorrisPratt.find("dummy", ""));
        Assertions.assertArrayEquals(new int[] {0}, KnuthMorrisPratt.find("dummy", "dum"));
        Assertions.assertArrayEquals(new int[] {1}, KnuthMorrisPratt.find("dummy", "um"));
        Assertions.assertArrayEquals(new int[] {}, KnuthMorrisPratt.find("dummy", "umy"));
        Assertions.assertArrayEquals(new int[] {2, 3}, KnuthMorrisPratt.find("dummy", "m"));

        Assertions.assertArrayEquals(new int[] {3}, KnuthMorrisPratt.find("SuperLongString", "erLo"));
        Assertions.assertArrayEquals(new int[] {6}, KnuthMorrisPratt.find("SuperLongString", "ong"));
        Assertions.assertArrayEquals(new int[] {}, KnuthMorrisPratt.find("SuperLongString", "long"));

        Assertions.assertArrayEquals(new int[] {1, 7, 12}, KnuthMorrisPratt.find("aabcabdabcbcabcc", "abc"));
    }


    @Test
    public void getPrefixFuntionTest() {
        Assertions.assertArrayEquals(new int[] {}, KnuthMorrisPratt.getPrefixFuntion(""));
        Assertions.assertArrayEquals(new int[] {0}, KnuthMorrisPratt.getPrefixFuntion("a"));
        Assertions.assertArrayEquals(new int[] {0, 0}, KnuthMorrisPratt.getPrefixFuntion("ab"));
        Assertions.assertArrayEquals(new int[] {0, 1}, KnuthMorrisPratt.getPrefixFuntion("aa"));
        Assertions.assertArrayEquals(new int[] {0, 0, 0, 1, 2, 3, 0}, KnuthMorrisPratt.getPrefixFuntion("abcabcd"));
        Assertions.assertArrayEquals(new int[] {0, 1, 0, 1, 2, 2, 3}, KnuthMorrisPratt.getPrefixFuntion("aabaaab"));
    }

}
