package algo.algebra;

// http://e-maxx.ru/algo/binomial_coeff
public class Binom {

    public static int c(int n, int k) {
        int c = 1;

        for (int i = n - k + 1; i <= n; ++ i) {
            c *= i;
        }
        for (int i = 2; i <= k; ++ i) {
            c /= i;
        }

        return c;
    }


    public static int fastC(int n, int k) {
        double res = 1;

        for (int i = 1; i <= k; ++ i) {
            res = res * (n - k + i) / i;
        }

        return (int)(res + 0.01);
    }

}
