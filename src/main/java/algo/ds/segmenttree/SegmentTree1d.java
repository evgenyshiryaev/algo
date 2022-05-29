package algo.ds.segmenttree;

// http://e-maxx.ru/algo/segment_tree
// https://cp-algorithms.com/data_structures/segment_tree.html
public class SegmentTree1d {

    public enum Type {
        SUM, MIN, MAX
    }


    private final Type type;

    private final int size;

    private final int[] tree;


    // constructor

    public SegmentTree1d(Type type, int[] array) {
        this.type = type;
        size = array.length;
        tree = new int[4 * size]; // 2 is not enough

        build(1, array, 0, array.length - 1);
        //System.out.println(Arrays.toString(tree));
    }


    private void build(int index, int[] array, int left, int right) {
        if (left == right) {
            tree[index] = array[left];
            return;
        }

        int middle = left + (right - left) / 2;
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;

        build(leftIndex, array, left, middle);
        build(rightIndex, array, middle + 1, right);

        updateTree(index, leftIndex, rightIndex);
    }


    // UPDATE

    public void update(int arrayIndex, int newVal) {
        update(1, 0, size - 1, arrayIndex, newVal);
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

        updateTree(index, leftIndex, rightIndex);
    }


    // calculate

    public int calc(int left, int right) {
        return calc(1, 0, size - 1, left, right);
    }

    private int calc(int index, int left, int right, int intervalLeft, int intervalRight) {
        if (intervalLeft > intervalRight) {
            switch (type) {
                case SUM:
                    return 0;
                case MIN:
                    return Integer.MAX_VALUE;
                case MAX:
                    return Integer.MIN_VALUE;
            }
        }

        if (intervalLeft == left && intervalRight == right) {
            return tree[index];
        }

        int middle = left + (right - left) / 2;
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;

        int leftVal = calc(leftIndex, left, middle, intervalLeft, Math.min(intervalRight, middle));
        int rightVal = calc(rightIndex, middle + 1, right, Math.max(intervalLeft, middle + 1), intervalRight);

        switch (type) {
            case SUM:
                return leftVal + rightVal;
            case MIN:
                return Math.min(leftVal, rightVal);
            case MAX:
                return Math.max(leftVal, rightVal);
            default:
                // no way
                throw new UnsupportedOperationException();
        }
    }


    private void updateTree(int index, int leftIndex, int rightIndex) {
        switch (type) {
            case SUM:
                tree[index] = tree[leftIndex] + tree[rightIndex];
                break;
            case MIN:
                tree[index] = Math.min(tree[leftIndex], tree[rightIndex]);
                break;
            case MAX:
                tree[index] = Math.max(tree[leftIndex], tree[rightIndex]);
                break;
        }
    }

}
