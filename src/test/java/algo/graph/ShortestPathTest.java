package algo.graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortestPathTest {

    @Test
    public void dijkstraTest() {
        @SuppressWarnings("unchecked")
        List<int[]>[] graph = new List[5];
        graph[0] = new ArrayList<>();
        graph[0].add(new int[] {1, 1});
        graph[0].add(new int[] {2, 10});
        graph[0].add(new int[] {4, 20});
        graph[1] = new ArrayList<>();
        graph[1].add(new int[] {0, 1});
        graph[1].add(new int[] {2, 5});
        graph[1].add(new int[] {3, 2});
        graph[2] = new ArrayList<>();
        graph[2].add(new int[] {0, 10});
        graph[2].add(new int[] {1, 5});
        graph[2].add(new int[] {4, 6});
        graph[3] = new ArrayList<>();
        graph[3].add(new int[] {1, 2});
        graph[3].add(new int[] {4, 15});
        graph[4] = new ArrayList<>();
        graph[4].add(new int[] {0, 20});
        graph[4].add(new int[] {2, 6});
        graph[4].add(new int[] {3, 15});

        int[] dist = {0, 1, 6, 3, 12};
        Assertions.assertArrayEquals(dist, ShortestPath.dijkstra1(graph, 0));
        Assertions.assertArrayEquals(dist, ShortestPath.dijkstra2(graph, 0));
    }

}
