// http://e-maxx.ru/algo/prefix_function

#include <assert.h>
#include <string>
#include <vector>

using namespace std;


// O(s) / O(s)
vector<int> prefix_function(string s) {
	vector<int> r(s.size());
	for (int i = 1; i < s.size(); ++i) {
		int j = r[i - 1];
		while (j > 0 && s[i] != s[j]) j = r[j - 1];
		if (s[i] == s[j]) ++j;
		r[i] = j;
	}
	return r;
}


// O(s + t) / O(s + t)
vector<int> find(string s, string t) {
	vector<int> r;
	if (t.size() == 0) return r;
	vector<int> p = prefix_function(t + '#' + s);
	for (int i = 0; i < s.size() - t.size() + 1; ++i)
		if (p[i + 2 * t.size()] == t.size()) r.push_back(i);
	return r;
}


int main() {
	assert(prefix_function("") == vector<int>());
	assert(prefix_function("a") == vector<int>({0}));
	assert(prefix_function("ab") == vector<int>({0, 0}));
	assert(prefix_function("aa") == vector<int>({0, 1}));
	assert(prefix_function("abcabcd") == vector<int>({0, 0, 0, 1, 2, 3, 0}));
	assert(prefix_function("aabaaab") == vector<int>({0, 1, 0, 1, 2, 2, 3}));

	assert(find("dummy", "") == vector<int>());
	assert(find("dummy", "dum") == vector<int>({0}));
	assert(find("dummy", "um") == vector<int>({1}));
	assert(find("dummy", "my") == vector<int>({3}));
	assert(find("dummy", "m") == vector<int>({2, 3}));
	assert(find("aabcabdabcbcabcc", "abc") == vector<int>({1, 7, 12}));

	return 0;
}