package algo;

// https://leetcode.com/problems/largest-component-size-by-common-factor/solution/
public class DisjointSet {

    private final int[] parent;

    private final int[] size;


    public DisjointSet(int size) {
        parent = new int[size + 1];
        this.size = new int[size + 1];

        for (int i = 0; i < size + 1; ++ i) {
            parent[i] = i;
            this.size[i] = 1;
        }
    }


    /** return the component id that the element x belongs to. */
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }

        return parent[x];
    }


    public int getSize(int x) {
        int px = find(x);

        return size[px];
    }


    /**
     * merge the two components that x, y belongs to respectively,
     * and return the merged component id as the result.
     */
    public int union(int x, int y) {
        int px = find(x);
        int py = find(y);

        // the two nodes share the same group
        if (px == py) {
            return px;
        }

        // otherwise, connect the two sets (components)
        if (size[px] > size[py]) {
            // add the node to the union with less members.
            // keeping px as the index of the smaller component
            int temp = px;
            px = py;
            py = temp;
        }

        // add the smaller component to the larger one
        parent[px] = py;
        size[py] += size[px];

        return py;
    }

}
