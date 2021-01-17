package algo.ds;

// binary indexed tree
// http://e-maxx.ru/algo/fenwick_tree
public class FenwickTree {

    private int[] tree;


    public void build(int size) {
        tree = new int[size];
    }

    public void build(int[] array) {
        build(array.length);
        for (int i = 0; i < array.length; ++ i) {
            inc(i, array[i]);
        }
    }


    public void inc(int index, int delta) {
        for (int i = index; i < tree.length; i = i | (i + 1)) {
            tree[i] += delta;
        }
    }


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

}
