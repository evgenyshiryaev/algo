#include <assert.h>
#include <vector>

using namespace std;


// https://projecteuler.net/overview=0003
// sqrt(n)
vector<int> factor(int n) {
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
	return primes;
}


// http://e-maxx.ru/algo/eratosthenes_sieve
// https://projecteuler.net/overview=0010
// O(n*loglogn)
vector<int> eratosthenesSieve(int n) {
	vector<bool> sieve(n + 1, true);
	vector<int> primes;
	if (n >= 2) primes.push_back(2);
	int i = 3;
	for (; 1LL * i * i <= n; i += 2)
		if (sieve[i]) {
			for (int j = i * i; j <= n; j += 2 * i) sieve[j] = false;
			primes.push_back(i);
		}
	for (; i <= n; i += 2)
		if (sieve[i]) primes.push_back(i);
	return primes;
}

vector<int> eratosthenesSieveOpt(int n) {
	int bound = (n - 1) / 2;
	vector<bool> sieve(bound + 1, true);
	vector<int> primes;
	if (n >= 2) primes.push_back(2);
	int i = 1;
	for (; i <= (sqrt(n) - 1) / 2; ++i)
		if (sieve[i]) {
			for (int j = 2 * i * (i + 1); j <= bound; j += 2 * i + 1) sieve[j] = false;
			primes.push_back(2 * i + 1);
		}
	for (; i <= bound; ++i)
		if (sieve[i]) primes.push_back(2 * i + 1);
	return primes;
}


int main() {
	assert(vector<int>{} == factor(1));
	assert(vector<int>{3} == factor(3));
	assert(vector<int>({3, 5}) == factor(15));

	assert(vector<int>({ 2, 3, 5, 7, 11, 13 }) == eratosthenesSieveOpt(15));
	assert(eratosthenesSieveOpt(15) == eratosthenesSieve(15));

	long long s = 0;
	for (int p : eratosthenesSieve(2000000)) s += p;
	assert(142913828922 == s);
	assert(eratosthenesSieveOpt(2000000) == eratosthenesSieve(2000000));
}
