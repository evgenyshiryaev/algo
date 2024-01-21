from sortedcontainers import SortedSet
from utils.bits import INT_MAX


# http://e-maxx.ru/algo/dijkstra
# O(V^2 + E)
# graph - map(vertex - [vertex, weight])
def dijkstra1(graph, start, target=None):
    V = len(graph)

    dist = [INT_MAX] * V
    dist[start] = 0
    visited = [False] * V
    parents = [None] * V

    for _ in range(V):
        from_v = None
        for i in range(V):
            if not visited[i] and (from_v is None or dist[i] < dist[from_v]):
                from_v = i
        if dist[from_v] == INT_MAX or from_v == target:
            break
        visited[from_v] = True

        for to_v, l in graph[from_v]:
            if dist[from_v] + l < dist[to_v]:
                dist[to_v] = dist[from_v] + l
                parents[to_v] = from_v

    return dist


# http://e-maxx.ru/algo/dijkstra_sparse
# O(E * log(V)))
# graph - map(vertex - [vertex, weight])
def dijkstra2(graph, start, target=None):
    dist = [INT_MAX] * len(graph)
    dist[start] = 0

    nearest = SortedSet(key=lambda v: (dist[v], v))
    nearest.add(start)

    while nearest:
        from_v = nearest.pop(0)
        if from_v == target:
            break
        for to_v, l in graph[from_v]:
            if dist[from_v] + l < dist[to_v]:
                nearest.discard(to_v)
                dist[to_v] = dist[from_v] + l
                nearest.add(to_v)

    return dist


# http://e-maxx.ru/algo/ford_bellman
# O(E * V)
# graph - [[from, to, weight]]
def bellman_ford(graph, V, start):
    dist = [INT_MAX] * V
    dist[start] = 0
    count = 0

    while True:
        any_change = False
        for from_v, to_v, weight in graph:
            if dist[from_v] != INT_MAX and dist[to_v] > dist[from_v] + weight:
                dist[to_v] = dist[from_v] + weight
                any_change = True
        if not any_change:
            return dist

        count += 1
        if count == V:
            # negative cycle
            return None


# http://e-maxx.ru/algo/floyd_warshall_algorithm
# O(V ^ 3)
# graph - adjacency matrix [[weight]]
def floyd_warshall(graph):
    V = len(graph)
    for k in range(V):
        for i in range(V):
            for j in range(V):
                if graph[i][k] != INT_MAX and graph[k][j] != INT_MAX:
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


if __name__ == '__main__':
    _graph = [[[1, 1], [2, 10], [4, 20]], [[2, 5], [3, 2]], [[4, 6]], [[4, 15]], [[2, 6], [3, 15]]]
    assert [0, 1, 6, 3, 12] == dijkstra1(_graph, 0)
    assert [0, 1, 6, 3, 12] == dijkstra2(_graph, 0)

    _graph = [[[1, 1], [2, 10], [4, 20]], [[2, 5], [3, 2]], [[4, 6]], [[4, 15]], [[2, 6], [3, 15]]]
    assert [0, 1, 10, INT_MAX, 20] == dijkstra1(_graph, 0, 1)
    assert [0, 1, 10, INT_MAX, 20] == dijkstra2(_graph, 0, 1)

    _graph = [[0, 1, 1], [0, 2, 10], [0, 4, 20],
              [1, 2, 5], [1, 3, 2],
              [2, 4, 6],
              [3, 4, 15],
              [4, 2, 6], [4, 3, 15]]
    assert [0, 1, 6, 3, 12] == bellman_ford(_graph, 5, 0)

    _graph = [[0, 1, 1], [1, 2, -1], [2, 1, -1]]
    assert bellman_ford(_graph, 3, 0) is None

    _graph = [
        [0,       1,       10,      INT_MAX, 20],
        [INT_MAX, 0,       5,       2,       INT_MAX],
        [INT_MAX, INT_MAX, 0,       INT_MAX, 6],
        [INT_MAX, INT_MAX, INT_MAX, 0,       15],
        [INT_MAX, INT_MAX, 6,       15,      0]]
    floyd_warshall(_graph)
    _dist = [
        [0,       1,       6, 3, 12],
        [INT_MAX, 0,       5, 2, 11],
        [INT_MAX, INT_MAX, 0, 21, 6],
        [INT_MAX, INT_MAX, 21, 0, 15],
        [INT_MAX, INT_MAX, 6, 15, 0]]
    assert _dist == _graph
