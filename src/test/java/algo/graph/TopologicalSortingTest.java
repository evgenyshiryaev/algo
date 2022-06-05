package algo.graph;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TopologicalSortingTest {

    @Test
    public void test() {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[] { List.of(1, 2), List.of(3), List.of(1, 3), List.of() };

        int[] expected = new int[] {0, 2, 1, 3};
        Assertions.assertArrayEquals(expected, TopologicalSorting.kahn(graph));
        Assertions.assertArrayEquals(expected, TopologicalSorting.dfs(graph));
    }


    @Test
    public void kahnCycleTest() {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[] { List.of(1), List.of(2), List.of(1) };

        Assertions.assertNull(TopologicalSorting.kahn(graph));
    }

}
