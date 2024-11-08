// http://e-maxx.ru/algo/euclid_algorithm
// http://e-maxx.ru/algo/extended_euclid_algorithm
// http://e-maxx.ru/algo/reverse_element

#include <assert.h>
#include <numeric>

using namespace std;


// use std::gcd()
int gcd_custom(int a, int b) {
	while (b) a %= b, swap(a, b);
	return a;
}


// use std::lcm()
int lcm_custom(int a, int b) {
	return a / gcd_custom(a, b) * b;
}


int gcd_ext(int a, int b, int& x, int& y) {
	if (a == 0) {
		x = 0; y = 1;
		return b;
	}
	int x1, y1;
	int d = gcd_ext(b % a, a, x1, y1);
	x = y1 - (b / a) * x1;
	y = x1;
	return d;
}


int mmi(int a, int mod) {
	int x, y;
	int g = gcd_ext(a, mod, x, y);
	if (g != 1) return -1;
	return (x % mod + mod) % mod;
}


int main() {
	assert(gcd_custom(590, 412) == gcd(590, 412));
	assert(gcd_custom(3789610, 1234630) == gcd(3789610, 1234630));

	assert(lcm_custom(590, 412) == lcm(590, 412));
	assert(lcm_custom(3789610, 1234630) == lcm(3789610, 1234630));

	assert(mmi(2, 5) == 3);
	assert(mmi(5, 11) == 9);
	assert(mmi(5, 10) == -1);

	return 0;
}