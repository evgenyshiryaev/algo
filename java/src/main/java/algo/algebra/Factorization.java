package algo.algebra;

import java.util.ArrayList;
import java.util.List;


// http://e-maxx.ru/algo/factorization
// https://en.wikipedia.org/wiki/Integer_factorization
public class Factorization {

    // https://en.wikipedia.org/wiki/Trial_division
    public static List<Integer> trialDivision(int n) {
        List<Integer> result = new ArrayList<>();

        int div = 2;
        while (n % div == 0) {
            result.add(div);
            n /= div;
        }

        div = 3;
        while (div * div <= n) {
            if (n % div == 0) {
                result.add(div);
                n /= div;
            } else {
                div += 2;
            }
        }

        if (n != 1) {
            result.add(n);
        }

        return result;
    }


    public static List<Integer> primeDivision(int n) {
        List<Integer> result = new ArrayList<>();

        List<Integer> primes = Eratosthenes.getPrimes((int)Math.sqrt(n));
        for (int prime : primes) {
            while (n % prime == 0) {
                result.add(prime);
                n /= prime;
            }
        }

        if (n != 1) {
            result.add(n);
        }

        return result;
    }

}
