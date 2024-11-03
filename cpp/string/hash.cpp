// http://e-maxx.ru/algo/string_hashes

#include <assert.h>
#include <string>
#include <vector>

using namespace std;

typedef long long ll;


const int P = 31; // prime ~ |alphabet|
const ll DIV = 1e9 + 7;


// O(s) / O(1)
// s[0] + p*s[1] + p^2*s[2] + ...
int hash(string s) {
	ll hash = 0, p_pow = 1;
	for (int i = 0; i < s.size(); ++i) {
		hash = (hash + (s[i] - 'a' + 1) * p_pow) % DIV;  // +1 to make hash non-zero
		p_pow = (p_pow * P) % DIV;
	}
	return hash;
}


// O(s) / O(1)
// http://e-maxx.ru/algo/rabin_karp
vector<int> find(string s, string t) {
	vector<int> r;
	if (t.size() == 0 || s.size() < t.size()) return r;

	ll hash_s = 0, hash_t = 0, p_pow_left = 1, p_pow_right = 1;
	for (int i = 0; i < t.size(); ++i) {
		hash_s = (hash_s + (s[i] - 'a' + 1) * p_pow_right) % DIV;
		hash_t = (hash_t + (t[i] - 'a' + 1) * p_pow_right) % DIV;
		p_pow_right = (p_pow_right * P) % DIV;
	}
	if (hash_s == hash_t) r.push_back(0);

	for (int i = t.size(); i < s.size(); ++i) {
		hash_s = (hash_s + (s[i] - 'a' + 1) * p_pow_right - (s[i - t.size()] - 'a' + 1) * p_pow_left) % DIV;
		if (hash_s < 0) hash_s += DIV;
		hash_t = (hash_t * P) % DIV;
		p_pow_left = (p_pow_left * P) % DIV;
		p_pow_right = (p_pow_right * P) % DIV;
		if (hash_s == hash_t) r.push_back(i + 1 - t.size());
	}

	return r;
}


int main() {
	assert(find("dummy", "") == vector<int>());
	assert(find("dummy", "dum") == vector<int>({ 0 }));
	assert(find("dummy", "um") == vector<int>({ 1 }));
	assert(find("dummy", "my") == vector<int>({ 3 }));
	assert(find("dummy", "m") == vector<int>({ 2, 3 }));
	assert(find("aabcabdabcbcabcc", "abc") == vector<int>({ 1, 7, 12 }));

	return 0;
}
