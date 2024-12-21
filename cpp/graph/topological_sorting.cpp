#include <assert.h>
#include <queue>
#include <vector>

using namespace std;


// O(V + E)
vector<int> kahn(vector<vector<int>>& graph) {
	int V = graph.size();

	vector<int> inDegrees(V);
	for (vector<int>& tos : graph)
		for (int to : tos) ++ inDegrees[to];

	deque<int> q;
	for (int v = 0; v < V; ++v)
		if (inDegrees[v] == 0) q.push_back(v);

	vector<int> r(V);
	int ri = 0;
	while (q.size()) {
		int v = q.front();
		q.pop_front();
		r[ri ++] = v;
		for (int to : graph[v])
			if (--inDegrees[to] == 0) q.push_back(to);
	}

	if (ri != V) r.resize(0);
	return r;
}


// http://e-maxx.ru/algo/topological_sort
// TODO: dfs


int main() {
	vector<vector<int>> graph({ {1, 2},  {3}, {1, 3}, {} });
	assert(vector<int>({ 0, 2, 1, 3 }) == kahn(graph));
	return 0;
}
