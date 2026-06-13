// http://e-maxx.ru/algo/lca_linear_offline
// time: O(n + q)

#include <vector>

using namespace std;

class LcaDisjointSet {
private:
    int n;
    vector<vector<int>> g, queries;
	vector<int> dsu, ancestor;
	vector<bool> visited;

	int dsu_get(int v) {
		return v == dsu[v] ? v : dsu[v] = dsu_get(dsu[v]);
	}

	void dsu_unite(int v0, int v1, int new_ancestor) {
		v0 = dsu_get(v0);
		v1 = dsu_get(v1);
		if (rand() & 1) swap(v0, v1);
		dsu[v0] = v1;
		ancestor[v1] = new_ancestor;
	}

public:
    LcaDisjointSet(int _n): n(_n), g(n), queries(n), dsu(n), ancestor(n), visited(n) {
		// init graph
		// init queries
		//int v0, v1; // read query
		//queries[v0].push_back(v1);
		//queries[v1].push_back(v0);
	}

	void dfs (int v0) {
		dsu[v0] = v0;
		ancestor[v0] = v0;
		visited[v0] = true;
		for (int v1 : g[v0])
			if (!visited[v1]) {
				dfs(v1);
				dsu_unite(v0, v1, v0);
			}
		for (int v1 : queries[v0])
			if (visited[v1])
				printf("%d %d -> %d\n", v0, v1, ancestor[dsu_get(v1)]);
	}
};


int main() {
	// read n
	int n;

	LcaDisjointSet lca(n);
	lca.dfs(0);
}
