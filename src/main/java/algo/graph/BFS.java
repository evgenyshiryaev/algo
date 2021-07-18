package algo.graph;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * BFS samples.
 */
public class BFS {

    // '+' - wall, '.' - empty cell
    public int bfs(char[][] graph, int[] entrance) {
        final int Y = graph.length;
        final int X = graph[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(entrance);
        graph[entrance[0]][entrance[1]] = '+';

        int result = 0;

        final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            while (size -- > 0) {
                int[] pos = q.removeFirst();
                int y = pos[0];
                int x = pos[1];

                if ((y == 0 || y == Y - 1 || x == 0 || x == X - 1) && !(y == entrance[0] && x == entrance[1])) {
                    return result;
                }

                for (int[] move : MOVES) {
                    int y1 = y + move[0];
                    int x1 = x + move[1];

                    if (y1 >= 0 && y1 < Y && x1 >=0 && x1 < X && graph[y1][x1] == '.') {
                        graph[y1][x1] = '+';
                        q.addLast(new int[] {y1, x1});
                    }
                }
            }

            ++ result;
        }

        return -1;
    }

}
