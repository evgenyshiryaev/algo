#include <vector>

using namespace std;

typedef long long ll;


int binpow(ll a, int b, int mod) {
    a %= mod;
    ll r = 1;
    while (b) {
        if (b & 1) r = r * a % mod;
        a = a * a % mod;
        b >>= 1;
    }
    return r;
}


vector<int> fact;
void factCount(int n, int mod) {
    fact.resize(n + 1);
    fact[0] = 1;
    for (int i = 1; i <= n; ++i) fact[i] = 1LL * fact[i - 1] * i % mod;
}


// http://e-maxx.ru/algo/reverse_element
int mmi(int a, int mod) {
    return binpow(a, mod - 2, mod);
}
