package algo.string;

import java.util.Arrays;

public class RabinKarp {

    public static int find(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] needleChars = needle.toCharArray();
        int needleHash = StringHash.polynomialRollingHash(needleChars, 0, needle.length());

        char[] haystackChars = haystack.toCharArray();

        int hash = 0;
        for (int i = needle.length() - 1; i < haystack.length(); ++ i) {
            hash = i == needle.length() - 1
                    ? StringHash.polynomialRollingHash(haystackChars, 0, needle.length())
                    : StringHash.polynomialRollingHash(hash, haystackChars[i - needle.length()], haystackChars[i]);

            if (hash == needleHash
                    && Arrays.equals(haystackChars, i - needle.length() + 1, i + 1, needleChars, 0, needle.length())) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }

}
