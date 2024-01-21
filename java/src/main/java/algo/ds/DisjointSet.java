package algo.ds;

// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3843/
public class DisjointSet {

    private final int[] root;

    // height of each vertex
    private final int[] rank;

    private int size;


    public DisjointSet(int size) {
        root = new int[size];
        rank = new int[size];
        this.size = size;

        for (int i = 0; i < size; ++ i) {
            root[i] = i;
            rank[i] = 1;
        }
    }


    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                ++ rank[rootX];
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
