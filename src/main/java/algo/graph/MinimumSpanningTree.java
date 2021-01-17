package algo.graph;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;


// http://e-maxx.ru/algo/mst_prim
public class MinimumSpanningTree {

    // O(V ^ 2)
    public static int prim1(int[][] graph) {
        int V = graph.length;

        // min cost to connect i-th vertex with already constructed tree
        int[] mins = new int[V];
        for (int i = 1; i < V; ++ i) {
            mins[i] = Integer.MAX_VALUE;
        }
        // get 0-th vertex first

        int result = 0;

        for (int i = 0; i < V; ++ i) {
            int minJ = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < V; ++ j) {
                if (mins[j] >= 0 && mins[j] < min) {
                    minJ = j;
                    min = mins[j];
                }
            }
            if (minJ == -1) {
                // not possible to build
                return -1;
            }

            result += min;
            mins[minJ] = -1;

            for (int j = 0; j < V; ++ j) {
                if (mins[j] > 0 && graph[j][minJ] < mins[j]) {
                    mins[j] = graph[j][minJ];
                }
            }
        }

        return result;
    }


    // O(E * log(V))
    public static int prim2(Map<Integer, List<int[]>> graph, int G) {
        int[] mins = new int[G];
        for (int i = 1; i < G; ++ i) {
            mins[i] = Integer.MAX_VALUE;
        }
        // get 0 first

        // cost - from
        TreeSet<int[]> set = new TreeSet<>((p0, p1) -> {
            int c = Integer.compare(p0[0], p1[0]);
            return c != 0 ? c : Integer.compare(p0[1], p1[1]);
        });
        set.add(new int[] {0, 0});

        int result = 0;

        for (int i = 0; i < G; ++ i) {
            if (set.isEmpty()) {
                // not possible to build
                return -1;
            }

            int[] min = set.first();
            set.remove(min);

            result += min[0];
            mins[min[1]] = -1;

            List<int[]> fromMin = graph.get(min[1]);
            if (fromMin != null) {
                for (int[] e : fromMin) {
                    int to = e[0];
                    int cost = e[1];

                    if (cost < mins[to]) {
                        set.remove(new int[] {mins[to], to});
                        mins[to] = cost;
                        set.add(new int[] {mins[to], to});
                    }
                }
            }
        }

        return result;
    }

}
