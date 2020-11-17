package algo;

import algo.algebra.ModularMultiplicativeInverse;

// https://cp-algorithms.com/string/string-hashing.html
public class StringHash {

    // prime
    private static final int P = 31;

    // 10^9 + 1
    private static final int M = 1000000009;

    private static final int P_INV = ModularMultiplicativeInverse.euclidMMI(P, M);

    private static int pPowMax;


    public static int polynomialRollingHash(char[] s, int start, int end) {
        int hash = 0;
        int pPow = 1;

        for (int i = start; i < end; ++ i) {
            pPowMax = pPow;
            hash = (hash + s[i] * pPow) % M;
            pPow = (pPow * P) % M;
        }

        return hash;
    }


    public static int polynomialRollingHash(int oldHash, char oldChar, char newChar) {
        return (int)(((1L * (oldHash - oldChar) * P_INV) % M + newChar * pPowMax) % M);
    }

}
