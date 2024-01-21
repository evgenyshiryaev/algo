package algo.algebra;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

// http://e-maxx.ru/algo/euclid_algorithm
public class Euclid {

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.signum() != 0 ? gcd(b, a.mod(b)) : a;
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


    // http://e-maxx.ru/algo/diofant_2_equation
    // a * x + b * y = c
    public static boolean diophantine(int a, AtomicInteger x, int b, AtomicInteger y, int c) {
        int g = gcdExt(Math.abs(a), Math.abs(b), x, y);
        if (c % g != 0) {
            return false;
        }

        int x0 = x.get();
        int y0 = y.get();

        x0 *= c / g;
        y0 *= c / g;
        if (a < 0) {
            x0 *= -1;
        }
        if (b < 0) {
            y0 *= -1;
        }

        x.set(x0);
        y.set(y0);

        return true;
    }

}
