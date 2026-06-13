// http://e-maxx.ru/algo/lca_simpler
// https://www.geeksforgeeks.org/dsa/binary-lifting-guide-for-competitive-programming/
// time: O(n*logn + q*logn)
// space: O(n*logn)

#include <vector>

using namespace std;

class LcaBinaryLifting {
private:
    int n, l, timer;
    vector<vector<int>> g, up;
    vector<int> timeIn, timeOut;

    bool upper(int v0, int v1) {
        return timeIn[v0] <= timeIn[v1] && timeOut[v0] >= timeOut[v1];
    }

public:
    LcaBinaryLifting(int _n): n(_n), timer(0), g(_n), up(_n), timeIn(_n), timeOut(_n) {
        l = 1;
        while ((1 << l) <= n) ++ l;
        for (int i = 0; i < n; ++ i) up[i].resize(l + 1);

        // init graph
    }

    void dfs(int v0, int p = 0) {
        timeIn[v0] = ++timer;
        up[v0][0] = p;
        for (int i = 1; i <= l; ++i)
            up[v0][i] = up[up[v0][i - 1]][i - 1];
        for (int v1 : g[v0])
            if (v1 != p) dfs(v1, v0);
        timeOut[v0] = ++timer;
    }

    int lca(int v0, int v1) {
        if (upper(v0, v1)) return v0;
        if (upper(v1, v0)) return v1;
        for (int i = l; i >= 0; -- i)
            if (!upper(up[v0][i], v1)) v0 = up[v0][i];
        return up[v0][0];
    }
};


int main() {
    // read n
    int n;

    LcaBinaryLifting lca(n);
    lca.dfs(0);

    while (69) {
        int v0, v1; // read query
        int res = lca.lca(v0, v1);
    }
}
