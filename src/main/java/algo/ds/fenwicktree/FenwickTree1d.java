package algo.ds.fenwicktree;

import java.util.Arrays;


// Fenwick tree (binary indexed tree) for 1d sum.
// http://e-maxx.ru/algo/fenwick_tree
public class FenwickTree1d {

    public enum Type {
        SUM, MIN, MAX
    }


    private final Type type;

    private final int[] tree;


    // constructor

    public FenwickTree1d(Type type, int size) {
        this.type = type;
        tree = new int[size];

        switch (type) {
            case SUM:
                // do nothing
                break;
            case MIN:
                Arrays.fill(tree, Integer.MAX_VALUE);
                break;
            case MAX:
                Arrays.fill(tree, Integer.MIN_VALUE);
                break;
        }
    }


    public FenwickTree1d(Type type, int[] array) {
        this(type, array.length);
        for (int i = 0; i < array.length; ++ i) {
            update(i, array[i]);
        }
    }


    // update
    // for SUM - any delta
    // for MIN - only decr
    // for MAX - only incr

    public void update(int index, int val) {
        for (int i = index; i < tree.length; i = i | (i + 1)) {
            switch (type) {
                case SUM:
                    tree[i] += val;
                    break;
                case MIN:
                    tree[i] = Math.min(tree[i], val);
                    break;
                case MAX:
                    tree[i] = Math.max(tree[i], val);
                    break;
            }
        }
    }


    // SUM

    public int sum(int left, int right) {
        return sum(right) - sum(left - 1);
    }


    public int sum(int right) {
        int result = 0;
        for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            result += tree[i];
        }
        return result;
    }


    // MIN

    public int min(int right) {
        int result = Integer.MAX_VALUE;
        for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            result = Math.min(result, tree[i]);
        }
        return result;
    }


    // MAX

    public int max(int right) {
        int result = Integer.MIN_VALUE;
        for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            result = Math.max(result, tree[i]);
        }
        return result;
    }

}
