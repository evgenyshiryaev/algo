package algo.algebra;

import java.util.concurrent.atomic.AtomicInteger;

// http://e-maxx.ru/algo/euclid_algorithm
public class Euclid {

    public static int gcd(int a, int b) {
        return b != 0 ? gcd (b, a % b) : a;
    }


    public static int lcm(int a, int b) {
        return a / gcd (a, b) * b;
    }


    // http://e-maxx.ru/algo/extended_Euclid_algorithm
    // a * x + b * y = gcd(a, b)
    public static int gcdExt(int a, int b, AtomicInteger x, AtomicInteger y) {
        if (a == 0) {
            x.set(0);
            y.set(1);
            return b;
        }

        int d = gcdExt(b % a, a, x, y);

        int xVal = y.get() - (b / a) * x.get();
        int yVal = x.get();

        x.set(xVal);
        y.set(yVal);

        return d;
    }

}
