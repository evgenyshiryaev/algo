// https://ru.algorithmica.org/cs/range-queries/sparse-table/
// https://www.geeksforgeeks.org/dsa/sparse-table/

#include <assert.h>
#include <bit>
#include <numeric>
#include <vector>

using namespace std;

int log2_floor(unsigned long i) {
    return bit_width(i) - 1;
}

class SparseTable {
private:
    int n;
    vector<vector<int>> st; // st[i][j] stores [j, j + 2^i - 1]

public:
    SparseTable(vector<int> a): n(a.size()), st(log2_floor(n) + 1, vector<int>(n)) {
        for (int j = 0; j < n; ++j) st[0][j] = a[j];
        for (int i = 1; (1 << i) <= n; ++ i)
            for (int j = 0; j + (1 << i) - 1 < n; ++ j)
                st[i][j] = min(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]); // or sum, or gcd
    }

    int rsq(int l, int r) { // sum for [l, r)
        long long sum = 0;
        for (int i = st.size() - 1; i >= 0; -- i)
            if ((1 << i) <= r - l) {
                sum += st[i][l];
                l += 1 << i;
            }
        return sum;
    }

    int rmq(int l, int r) { // min for [l, r)
        int t = log2_floor(r - l);
        return min(st[t][l], st[t][r - (1 << t)]);
    }

    int rgq(int l, int r) { // gcd for [l, r)
        int t = log2_floor(r - l);
        return min(st[t][l], st[t][r - (1 << t)]);
    }
};


int main() {
    vector<int> a {1, -2, 10, 5, 0, -1, 7, 7, 6, 2};

    SparseTable st(a);
    assert(1 == st.rmq(0, 1));
    assert(-2 == st.rmq(0, 2));
    assert(-2 == st.rmq(0, 3));
    assert(-2 == st.rmq(0, 9));
    assert(-2 == st.rmq(1, 9));
    assert(-1 == st.rmq(2, 9));
    assert(0 == st.rmq(2, 5));
}
