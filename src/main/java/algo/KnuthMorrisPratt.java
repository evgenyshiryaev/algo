package algo;

import java.util.ArrayList;
import java.util.List;

import algo.utils.Utils;


// http://e-maxx.ru/algo/prefix_function
public class KnuthMorrisPratt {

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


    // O(s + t) / O(t)
    public static int[] find(String s, String t) {
        int T = t.length();
        if (T == 0) {
            return new int[] {};
        }

        int[] prefix = getPrefixFuntion(t);

        List<Integer> result = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);

            while (j == T || (j > 0 && c != t.charAt(j))) {
                j = prefix[j - 1];
            }

            if (c == t.charAt(j) && ++ j == T) {
                result.add(i + 1 - T);
            }
        }

        return Utils.toArray(result);
    }

}
