package algo.ds;


// http://e-maxx.ru/algo/segment_tree
// https://cp-algorithms.com/data_structures/segment_tree.html
public class SegmentTree {

    private int[] tree;


    public void build(int array[]) {
        tree = new int[4 * array.length];

        build(1, array, 0, array.length - 1);
    }


    public int sum(int left, int right) {
        return sum(1, 0, tree.length / 2 - 1, left, right);
    }


    public void update(int arrayIndex, int newVal) {
        update(1, 0, tree.length / 2 - 1, arrayIndex, newVal);
    }


    private void build(int index, int array[], int left, int right) {
        if (left == right) {
            tree[index] = array[left];
            return;
        }

        int middle = left + (right - left) / 2;
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;

        build(leftIndex, array, left, middle);
        build(rightIndex, array, middle + 1, right);

        tree[index] = tree[leftIndex] + tree[rightIndex];
    }


    private int sum(int index, int left, int right, int intervalLeft, int intervalRight) {
        if (intervalLeft > intervalRight) {
            return 0;
        }

        if (intervalLeft == left && intervalRight == right) {
            return tree[index];
        }

        int middle = left + (right - left) / 2;
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;

        return sum(leftIndex, left, middle, intervalLeft, Math.min(intervalRight, middle))
               + sum(rightIndex, middle + 1, right, Math.max(intervalLeft, middle + 1), intervalRight);
    }


    private void update(int index, int left, int right, int arrayIndex, int newVal) {
        if (left == right) {
            tree[index] = newVal;
            return;
        }

        int middle = left + (right - left) / 2;
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;

        if (arrayIndex <= middle) {
            update(leftIndex, left, middle, arrayIndex, newVal);
        } else {
            update(rightIndex, middle + 1, right, arrayIndex, newVal);
        }

        tree[index] = tree[leftIndex] + tree[rightIndex];
    }

}
