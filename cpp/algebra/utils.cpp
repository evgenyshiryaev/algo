#include <vector>

using namespace std;

using ll = long long;


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

vector<vector<int>> multMat(vector<vector<int>>& m0, vector<vector<int>>& m1) {
    int R0 = m0.size(), C0 = m0[0].size();
    int R1 = m1.size(), C1 = m1[0].size();
    vector<vector<int>> res(R0, vector<int>(C1));
    for (int i = 0; i < R0; ++ i)
        for (int j = 0; j < C1; ++ j)
            for (int k = 0; k < R1; ++ k)
                res[i][j] += m0[i][k] * m1[k][j];
    return res;
}
