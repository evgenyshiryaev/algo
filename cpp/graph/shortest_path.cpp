#include <assert.h>
#include <queue>
#include <vector>

using namespace std;

using int2 = tuple<int, int>;


// http://e-maxx.ru/algo/dijkstra
// O(V ^ 2 + E)
// graph - vertex -> [vertex, weight]
vector<int> dijkstra0(vector<vector<int2>>& graph, int start) {
	size_t n = graph.size();
	vector<int> dists(n, INT_MAX), parents(n);
	vector<bool> visited(n);
	dists[start] = 0;

	for (int i = 0; i < n; ++ i) {
		int from = -1;
		for (int j = 0; j < n; ++ j)
			if (!visited[j] && (from == -1 || dists[j] < dists[from])) from = j;
		if (dists[from] == INT_MAX) break;
		//if (from == target) break;
		visited[from] = true;

		for (auto& [to, len] : graph[from]) {
			if (dists[from] + len < dists[to]) {
				dists[to] = dists[from] + len;
				parents[to] = from;
			}
		}
	}

	return dists;
}


// http://e-maxx.ru/algo/dijkstra_sparse
// O(E * log(V)))
// graph - vertex -> [vertex, weight]
vector<int> dijkstra1(vector<vector<int2>>& graph, int start) {
	vector<int> dists(graph.size(), INT_MAX);
	vector<int> parents(graph.size());
	priority_queue<int2, vector<int2>, greater<int2>> nears;  // distance, vertex

	dists[start] = 0;
	nears.push({0, start});

	while (!nears.empty()) {
		auto [dist, from] = nears.top();
		nears.pop();
		if (dist > dists[from]) continue;
		//if (from == target) break;

		for (auto [to, len] : graph[from]) {
			if (dists[from] + len < dists[to]) {
				dists[to] = dists[from] + len;
				parents[to] = from;
				nears.push({dists[to], to});
			}
		}
	}

	return dists;
}


// http://e-maxx.ru/algo/ford_bellman
// O(E * V)
// graph - [[from, to, weight]]
// TODO: bellmanFord


// http://e-maxx.ru/algo/floyd_warshall_algorithm
// O(V ^ 3)
// graph - adjacency matrix [[weight]]
// TODO: floydWarshall


int main() {
	// dijkstra
	vector<vector<int2>> graph{
		{{1, 1}, {2, 10}, {4, 20}},
		{{2, 5}, {3, 2}},
		{{4, 6}},
		{{4, 15}},
		{{2, 6}, {3, 15}}};
	assert(vector<int>({ 0, 1, 6, 3, 12 }) == dijkstra0(graph, 0));
	assert(vector<int>({ 0, 1, 6, 3, 12 }) == dijkstra1(graph, 0));

	return 0;
}
