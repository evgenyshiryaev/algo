package algo.graph;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


// http://e-maxx.ru/algo/dijkstra
// http://e-maxx.ru/algo/dijkstra_sparse
public class ShortestPath {

    // O(V ^ 2 + E)
    // graph - map (vertex - [vertex, weight])
    public static int[] dijkstra1(List<int[]>[] graph, int start) {
        int V = graph.length;

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] parents = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V; ++ i) {
            int vertex = -1;
            for (int j = 0; j < V; ++j) {
                if (!visited[j] && (vertex == -1 || dist[j] < dist[vertex])) {
                    vertex = j;
                }
            }

            if (dist[vertex] == Integer.MAX_VALUE) {
                break;
            }

            visited[vertex] = true;

            for (int[] pair : graph[vertex]) {
                int to = pair[0];
                int len = pair[1];
                if (dist[vertex] + len < dist[to]) {
                    dist[to] = dist[vertex] + len;
                    parents[to] = vertex;
                }
            }
        }

        return dist;
    }


    // O(E * log(V)))
    public static int[] dijkstra2(List<int[]>[] graph, int start) {
        int V = graph.length;

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int[] parents = new int[V];

        // pairs (distance, vertex)
        TreeSet<Integer> nearest = new TreeSet<>((v0, v1) -> {
            int c = Integer.compare(dist[v0], dist[v1]);
            return c != 0 ? c : Integer.compare(v0, v1);
        });
        nearest.add(start);

        while (!nearest.isEmpty()) {
            int from = nearest.pollFirst();

            for (int[] pair : graph[from]) {
                int to = pair[0];
                int len = pair[1];
                if (dist[from] + len < dist[to]) {
                    nearest.remove(to);
                    dist[to] = dist[from] + len;
                    nearest.add(to);
                    parents[to] = from;
                }
            }
        }

        return dist;
    }

}
