// http://e-maxx.ru/algo/z_function

#include <assert.h>
#include <string>
#include <vector>

using namespace std;


// O(s) / O(s)
vector<int> z_function(string s) {
	vector<int> z(s.size());
	for (int i = 1, l = 0, r = 0; i < s.size(); ++i) {
		if (i <= r)	z[i] = min(r - i + 1, z[i - l]);
		while (i + z[i] < s.size() && s[z[i]] == s[i + z[i]]) ++z[i];
		if (i + z[i] - 1 > r) l = i, r = i + z[i] - 1;
	}
	return z;
}


// O(s + t) / O(s + t)
vector<int> find(string s, string t) {
	vector<int> r;
	if (t.size() == 0) return r;
	vector<int> z = z_function(t + '#' + s);
	for (int i = t.size() + 1; i < s.size() + 2; ++i)
		if (z[i] == t.size()) r.push_back(i - t.size() - 1);
	return r;
}


int main() {
	assert(z_function("") == vector<int>());
	assert(z_function("a") == vector<int>({ 0 }));
	assert(z_function("ab") == vector<int>({ 0, 0 }));
	assert(z_function("aa") == vector<int>({ 0, 1 }));
	assert(z_function("aaaaa") == vector<int>({ 0, 4, 3, 2, 1 }));
	assert(z_function("abcabcd") == vector<int>({ 0, 0, 0, 3, 0, 0, 0 }));
	assert(z_function("aabaaab") == vector<int>({ 0, 1, 0, 2, 3, 1, 0 }));

	assert(find("dummy", "") == vector<int>());
	assert(find("dummy", "dum") == vector<int>({ 0 }));
	assert(find("dummy", "um") == vector<int>({ 1 }));
	assert(find("dummy", "my") == vector<int>({ 3 }));
	assert(find("dummy", "m") == vector<int>({ 2, 3 }));
	assert(find("aabcabdabcbcabcc", "abc") == vector<int>({ 1, 7, 12 }));

	return 0;
}
