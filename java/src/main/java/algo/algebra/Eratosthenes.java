package algo.algebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// http://e-maxx.ru/algo/eratosthenes_sieve
public class Eratosthenes {

    public static List<Integer> getPrimes(int n) {
        if (n < 2) {
            return Collections.emptyList();
        }

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int j = 4; j <= n; j += 2) {
            primes[j] = false;
        }

        int sqr;
        for (int i = 3; (sqr = i * i) <= n; i += 2) {
            if (primes[i]) {
                for (int j = sqr; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (primes[i]) {
                result.add(i);
            }
        }
        return result;
    }

}
