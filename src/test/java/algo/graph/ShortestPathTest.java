package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
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
        graph[1].add(new int[] {2, 5});
        graph[1].add(new int[] {3, 2});
        graph[2] = new ArrayList<>();
        graph[2].add(new int[] {4, 6});
        graph[3] = new ArrayList<>();
        graph[3].add(new int[] {4, 15});
        graph[4] = new ArrayList<>();
        graph[4].add(new int[] {2, 6});
        graph[4].add(new int[] {3, 15});

        int[] dist = {0, 1, 6, 3, 12};
        Assertions.assertArrayEquals(dist, ShortestPath.dijkstra1(graph, 0));
        Assertions.assertArrayEquals(dist, ShortestPath.dijkstra2(graph, 0));
    }


    @Test
    public void bellmanFordTest() {
        int[][] graph = {
            {0, 1, 1}, {0, 2, 10}, {0, 4, 20},
            {1, 2, 5}, {1, 3, 2},
            {2, 4, 6},
            {3, 4, 15},
            {4, 2, 6}, {4, 3, 15}};

        int[] dist = {0, 1, 6, 3, 12};
        Assertions.assertArrayEquals(dist, ShortestPath.bellmanFord(graph, 5, 0));
    }


    @Test
    public void bellmanFordNegativeCycleTest() {
        int[][] graph = {{0, 1, 1}, {1, 2, -1}, {2, 1, -1}};
        Assertions.assertNull(ShortestPath.bellmanFord(graph, 3, 0));
    }


    @Test
    public void floydWarshallTest() {
        int[][] graph = {
                {0,                 1,                 10,                Integer.MAX_VALUE, 20},
                {Integer.MAX_VALUE, 0,                 5,                 2,                 Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,                 Integer.MAX_VALUE, 6},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0,                 15},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 6,                 15,                0}};
        ShortestPath.floydWarshall(graph);

        int[][] dist = {
                {0,                 1,                 6, 3, 12},
                {Integer.MAX_VALUE, 0,                 5, 2, 11},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 21, 6},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 21, 0, 15},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 15, 0}};
        Assertions.assertTrue(Arrays.deepEquals(dist, graph));
    }

}
