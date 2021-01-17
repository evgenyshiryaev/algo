package algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumSpanningTreeTest {

    @Test
    public void prim1Test() {
        Assertions.assertEquals(0, MinimumSpanningTree.prim1(new int[][] {}));
        Assertions.assertEquals(5, MinimumSpanningTree.prim1(new int[][] {{0, 5}, {5, 0}}));

        Assertions.assertEquals(5, MinimumSpanningTree.prim1(new int[][]
                {{0, 2, 3},
                 {2, 0, 4},
                 {3, 4, 0}}));
    }


    @Test
    public void prim2Test() {
        Assertions.assertEquals(0, MinimumSpanningTree.prim2(Collections.emptyMap(), 0));

        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(new int[] {1, 5});
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new int[] {0, 5});
        Assertions.assertEquals(5, MinimumSpanningTree.prim2(graph, 2));

        graph = new HashMap<>();
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(new int[] {1, 2});
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(new int[] {2, 3});
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new int[] {0, 2});
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new int[] {2, 4});
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new int[] {0, 3});
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new int[] {1, 4});
        Assertions.assertEquals(5, MinimumSpanningTree.prim2(graph, 3));
    }

}
