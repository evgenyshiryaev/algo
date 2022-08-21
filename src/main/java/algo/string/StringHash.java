package algo.string;

import algo.algebra.ModularMultiplicativeInverse;


// https://cp-algorithms.com/string/string-hashing.html
public class StringHash {

    // prime
    private static final int P = 31;

    // 10^9 + 1
    private static final int M = 1_000_000_009;

    private static final int P_INV = ModularMultiplicativeInverse.euclidMMI(P, M);

    private static long pPowMax;


    public static int polynomialRollingHash(char[] s, int start, int end) {
        long hash = 0L;
        long pPow = 1L;

        for (int i = start; i < end; ++ i) {
            pPowMax = pPow;
            hash = (hash + pPow * s[i]) % M;
            pPow = (pPow * P) % M;
        }

        return (int)hash;
    }


    public static int polynomialRollingHash(int oldHash, char oldChar, char newChar) {
        return (int)((((1L * M  + oldHash - oldChar) * P_INV) % M + pPowMax * newChar) % M);
    }

}
