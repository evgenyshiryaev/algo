package algo.ds;

// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3843/
public class DisjointSet {

    private final int[] roots;

    // height of each vertex
    private final int[] ranks;

    private int size;


    public DisjointSet(int size) {
        roots = new int[size];
        ranks = new int[size];
        this.size = size;

        for (int i = 0; i < size; ++ i) {
            roots[i] = i;
            ranks[i] = 1;
        }
    }


    public int find(int x) {
        if (x == roots[x]) {
            return x;
        }
        return roots[x] = find(roots[x]);
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
            } else if (ranks[rootX] < ranks[rootY]) {
                roots[rootX] = rootY;
            } else {
                roots[rootY] = rootX;
                ++ ranks[rootX];
            }
            -- size;
        }
    }


    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int size() {
        return size;
    }

}
