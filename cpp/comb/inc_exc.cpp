//http://e-maxx.ru/algo/inclusion_exclusion_principle

#include <assert.h>
#include <vector>

using namespace std;


// counts co-primes with n in [2, r]
int coprimes(int n, int r) {
	// see algebra/primes.cpp
	vector<int> primes;
	if ((n & 1) == 0) {
		primes.push_back(2);
		while ((n & 1) == 0) n >>= 1;
	}
	for (int f = 3; 1LL * f * f <= n; f += 2) {
		if (n % f == 0) {
			primes.push_back(f);
			while (n % f == 0) n /= f;
		}
	}
	if (n != 1) primes.push_back(n);

	int sum = 0, maskMax = 1 << primes.size();
	for (int mask = 1; mask < maskMax; ++ mask) {
		int mult = 1, bits = 0;
		for (int i = 0; i < primes.size(); ++ i) {
			if (mask & (1 << i)) {
				++ bits;
				mult *= primes[i];
			}
		}
		sum += r / mult * (bits % 2 ? 1 : -1);
	}

	return r - 1 - sum;
}


int main() {
	assert(0 == coprimes(8, 2));
	assert(4 == coprimes(8, 10));
	assert(2 == coprimes(6, 10));

	return 0;
}
