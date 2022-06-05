package algo.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


public class TopologicalSorting {

    // O(V + E)
    public static int[] kahn(List<Integer>[] graph) {
        int V = graph.length;

        int[] inDegrees = new int[V];
        for (List<Integer> tos : graph) {
            for (int  to : tos) {
                ++ inDegrees[to];
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int v = 0; v < V; ++ v) {
            if (inDegrees[v] == 0) {
                queue.addLast(v);
            }
        }

        int[] result = new int[V];
        int ri = 0;
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            result[ri ++] = v;

            for (int to : graph[v]) {
                if (-- inDegrees[to] == 0) {
                    queue.addLast(to);
                }
            }
        }

        return ri == V ? result : null;
    }


    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] result;
    private static int ri;

    public static int[] dfs(List<Integer>[] graph) {
        TopologicalSorting.graph = graph;

        int V = graph.length;
        visited = new boolean[V];
        result = new int[V];
        ri = V - 1;

        for (int v = 0; v < V; ++ v) {
            if (!visited[v]) {
                dfsHelper(v);
            }
        }

        return ri == -1 ? result : null;
    }


    private static void dfsHelper(int v) {
        visited[v] = true;
        for (int to : graph[v]) {
            if (!visited[to]) {
                dfsHelper(to);
            }
        }
        result[ri --] = v;
    }

}
