package algo.string;

// http://e-maxx.ru/algo/palindromes_count
public class Palindrome {

    // d1[i] - odd palindrome count with center at i
    // d2[i] - even palindrome count with center at (i - 1, i)


    // O(n^2)
    public static int[][] countN2(String s) {
        int S = s.length();

        int[][] d = new int[2][S];
        int[] d1 = d[0];
        int[] d2 = d[1];

        for (int i = 0; i < S; ++ i) {
            d1[i] = 1;
            while (i - d1[i] >= 0 && i + d1[i] < S
                    && s.charAt(i - d1[i]) == s.charAt(i + d1[i])) {
                ++ d1[i];
            }

            d2[i] = 0;
            while (i - d2[i] - 1 >= 0 && i + d2[i] < S
                    && s.charAt(i - d2[i] - 1) == s.charAt(i + d2[i])) {
                ++ d2[i];
            }
        }

        return d;
    }

    // O(n)
    public static int[][] manacher(String s) {
        int[][] d = new int[2][s.length()];

        manacherHelper(s, d[0], true);
        manacherHelper(s, d[1], false);

        return d;
    }


    private static void manacherHelper(String s, int[] d, boolean odd) {
        int S = s.length();
        int l = 0;
        int r = -1;
        int extra = odd ? 0 : 1;

        for (int i = 0; i < d.length; ++ i) {
            int k = i > r ? 1 - extra : Math.min(d[l + r - i + extra], r - i + 1);

            while (i + k < S && i - k - extra >=  0
                    && s.charAt(i + k) == s.charAt(i - k - extra)) {
                ++ k;
            }
            d[i] = k;

            if (i + k - 1 > r) {
                l = i - k + 1 - extra;
                r = i + k - 1;
            }
        }
    }


}
