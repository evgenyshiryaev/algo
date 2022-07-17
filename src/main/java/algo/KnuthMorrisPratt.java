package algo;

import java.util.ArrayList;
import java.util.List;

import algo.utils.Utils;

// http://e-maxx.ru/algo/prefix_function
public class KnuthMorrisPratt {

    private static final char DELIMITER = (char)0;


    // O(n) / O(n)
    public static int[] getPrefixFuntion(String s) {
        int S = s.length();
        int[] prefix = new int[S];

        for (int i = 1; i < S; ++ i) {
            int j = prefix[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefix[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                ++ j;
            }

            prefix[i] = j;
        }

        return prefix;
    }


    // O(s + t) / O(s + t)
    public static int[] find(String s, String t) {
        int T = t.length();
        if (T == 0) {
            return new int[] {};
        }

        String s1 = String.format("%s%c%s", t, DELIMITER, s);
        int[] prefix = getPrefixFuntion(s1);

        List<Integer> result = new ArrayList<>();

        int start = 2 * T;
        for (int i = start; i < s1.length(); ++ i) {
            if (prefix[i] == T) {
                result.add(i - start);
            }
        }

        return Utils.toArray(result);
    }

}
