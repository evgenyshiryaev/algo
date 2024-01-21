package algo.graph;

import java.util.ArrayList;
import java.util.List;


/**
 * Graph utilities.
 */
public class GraphUtils {

    /**
     * Builds graph using edges.
     * @param n number of vertices
     * @param edges edges
     * @return graph
     */
    public static List<Integer>[] build(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++ i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
}
