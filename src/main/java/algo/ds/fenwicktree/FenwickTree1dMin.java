package algo.ds.fenwicktree;

import java.util.Arrays;


// Fenwick tree (binary indexed tree) for 1d min.
// http://e-maxx.ru/algo/fenwick_tree
public class FenwickTree1dMin {

    private int[] tree;


    public void build(int size) {
        tree = new int[size];
        Arrays.fill(tree, Integer.MAX_VALUE);
    }

    public void build(int[] array) {
        build(array.length);
        for (int i = 0; i < array.length; ++ i) {
            update(i, array[i]);
        }
    }


    // only decr is supported
    public void update(int index, int val) {
        for (int i = index; i < tree.length; i = i | (i + 1)) {
            tree[i] = Math.min(tree[i], val);
        }
    }


    public int min(int right) {
        int result = Integer.MAX_VALUE;
        for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            result = Math.min(result, tree[i]);
        }
        return result;
    }

}
