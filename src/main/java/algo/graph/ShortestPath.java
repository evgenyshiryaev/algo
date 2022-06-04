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
            int from = -1;
            for (int j = 0; j < V; ++j) {
                if (!visited[j] && (from == -1 || dist[j] < dist[from])) {
                    from = j;
                }
            }

            if (dist[from] == Integer.MAX_VALUE) {
                break;
            }
//            if (from == target) {
//                break;
//            }

            visited[from] = true;

            for (int[] pair : graph[from]) {
                int to = pair[0];
                int len = pair[1];
                if (dist[from] + len < dist[to]) {
                    dist[to] = dist[from] + len;
                    parents[to] = from;
                }
            }
        }

        return dist;
    }


    // O(E * log(V)))
    // graph - map (vertex - [vertex, weight])
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
//            if (from == target) {
//                break;
//            }

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


    // O(E * V)
    // graph - [[from, to, weight]]
    public static int[] bellmanFord(int[][] graph, int V, int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

//        int[] prev = new int[V];
//        Arrays.fill(prev, -1);

        // max (V - 1) times if no negative cycle
        int count = 0;
        while (true) {
            boolean anyChange = false;

            for (int[] e : graph) {
                if (dist[e[0]] != Integer.MAX_VALUE && dist[e[1]] > dist[e[0]] + e[2]) {
                    dist[e[1]] = dist[e[0]] + e[2];
//                    prev[e[1]] = e[0];
                    anyChange = true;
                }
            }

            if (!anyChange) {
                return dist;
            }

            if (++ count == V) {
                // negative cycle
                return null;
            }
        }
    }

}
