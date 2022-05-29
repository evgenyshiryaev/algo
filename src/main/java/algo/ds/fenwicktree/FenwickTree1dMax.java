package algo.ds.fenwicktree;

import java.util.Arrays;


// Fenwick tree (binary indexed tree) for 1d max.
// http://e-maxx.ru/algo/fenwick_tree
public class FenwickTree1dMax {

    private int[] tree;


    public void build(int size) {
        tree = new int[size];
        Arrays.fill(tree, Integer.MIN_VALUE);
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
            tree[i] = Math.max(tree[i], val);
        }
    }


    public int max(int right) {
        int result = Integer.MIN_VALUE;
        for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            result = Math.max(result, tree[i]);
        }
        return result;
    }

}
