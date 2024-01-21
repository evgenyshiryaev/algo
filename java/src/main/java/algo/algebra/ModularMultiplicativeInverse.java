package algo.algebra;

import java.util.concurrent.atomic.AtomicInteger;


// http://e-maxx.ru/algo/reverse_element
// for (a, m) find b, so a * b = 1 mod m
public class ModularMultiplicativeInverse {

    // O(log m)
    public static int euclidMMI(int a, int m) {
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();

        int g = Euclid.gcdExt(a, m, x, y);

        return g != 1 ? 0 : (x.get() % m + m) % m;
    }


    // O(m)
    public static int[] euclidMMIs(int m) {
        int[] r = new int[m];

        r[1] = 1;
        for (int i = 2; i < m; ++ i) {
            r[i] = (m - (m / i) * r[m % i] % m) % m;
        }

        return r;
    }


    /**
     * Calculates (a mod m) / b.
     */
    public static int divideMod(int a, int b, int m) {
        int c = euclidMMI(b, m);
        return (int)((1L * a * c) % m);
    }

}
