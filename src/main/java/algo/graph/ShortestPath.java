package algo.graph;

import java.util.*;


public class ShortestPath {

    // http://e-maxx.ru/algo/dijkstra
    // O(V ^ 2 + E)
    // graph - vertex -> [vertex, weight]
    public static int[] dijkstra1(List<int[]>[] graph, int start) {
        int V = graph.length;

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] parents = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V; ++ i) {
            int from = -1;
            for (int j = 0; j < V; ++ j) {
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


    // http://e-maxx.ru/algo/dijkstra_sparse
    // O(E * log(V)))
    // graph - vertex -> [vertex, weight]
    public static int[] dijkstra2(List<int[]>[] graph, int start) {
        int V = graph.length;

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int[] parents = new int[V];

        // pairs (distance, vertex)
        TreeSet<Integer> nearest = new TreeSet<>(
                Comparator.comparingInt((Integer v) -> dist[v]).thenComparingInt(v -> v));
        nearest.add(start);

        // O(E * log(E)))
//        Queue<IntPair> nearest = new PriorityQueue<>(Comparator.comparingInt(p -> p.a));
//        nearest.add(new IntPair(0, start));

        while (!nearest.isEmpty()) {
            int from = nearest.pollFirst();
//            var fromPair = nearest.poll();
//            int from = fromPair.b;
//            if (fromPair.a > dist[from]) {
//                continue;
//            }
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
//                    nearest.add(new IntPair(dist[to], to));
                    parents[to] = from;
                }
            }
        }

        return dist;
    }


    // http://e-maxx.ru/algo/ford_bellman
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


    // http://e-maxx.ru/algo/floyd_warshall_algorithm
    // O(V ^ 3)
    // graph - adjacency matrix [[weight]]
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        for (int k = 0; k < V; ++ k) {
            for (int i = 0; i < V; ++ i) {
                for (int j = 0; j < V; ++ j) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
    }

}
