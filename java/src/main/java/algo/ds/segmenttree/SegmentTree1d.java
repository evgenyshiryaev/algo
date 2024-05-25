package algo.ds.segmenttree;

// http://e-maxx.ru/algo/segment_tree
// https://cp-algorithms.com/data_structures/segment_tree.html
// https://www.hackerearth.com/practice/notes/segment-tree-and-lazy-propagation
public class SegmentTree1d {

    public enum Type {
        SUM, MIN, MAX
    }


    private final Type type;

    private final int size;

    private final int[] tree;

    private final int[] lazy;


    public SegmentTree1d(Type type, int[] array) {
        this.type = type;
        size = array.length;
        tree = new int[size << 2];
        lazy = new int[size << 2];

        build(1, array, 0, array.length - 1);
//        System.out.println(java.util.Arrays.toString(tree));
    }


    private void build(int treeI, int[] array, int arrayI0, int arrayI1) {
        if (arrayI0 == arrayI1) {
            tree[treeI] = array[arrayI0];
            return;
        }

        int arrayMiddleI = arrayI0 + ((arrayI1 - arrayI0) >> 1);
        build(treeI << 1, array, arrayI0, arrayMiddleI);
        build((treeI << 1) | 1, array, arrayMiddleI + 1, arrayI1);
        updateTree(treeI);
    }


    public void update(int i, int diff) {
        update(i, i, diff);
    }

    public void update(int i0, int i1, int diff) {
        update(1, 0, size - 1, i0, i1, diff);
    }

    private void update(int treeI, int arrayI0, int arrayI1, int updateI0, int updateI1, int diff) {
//        System.out.println(String.format("%d %d %d %d %d %d", treeI, arrayI0, arrayI1, updateI0, updateI1, diff));

        int treeLeftI = treeI << 1;
        int treeRightI = treeLeftI | 1;

        if (lazy[treeI] != 0) {
            updateTree(treeI, arrayI0, arrayI1, lazy[treeI]);
            // if not leaf - apply lazy update
            if (arrayI0 != arrayI1) {
                lazy[treeLeftI] += lazy[treeI];
                lazy[treeRightI] += lazy[treeI];
            }
            lazy[treeI] = 0;
        }

        if (arrayI0 > arrayI1 || arrayI0 > updateI1 || arrayI1 < updateI0) {
            return;
        }

        // if segment is fully within update range
        if (arrayI0 >= updateI0 && arrayI1 <= updateI1) {
            updateTree(treeI, arrayI0, arrayI1, diff);
            // if not leaf - apply lazy update
            if (arrayI0 != arrayI1) {
                lazy[treeLeftI] += diff;
                lazy[treeRightI] += diff;
            }
            return;
        }

        int arrayMiddleI = arrayI0 + ((arrayI1 - arrayI0) >> 1);
        update(treeLeftI, arrayI0, arrayMiddleI, updateI0, updateI1, diff);
        update(treeRightI, arrayMiddleI + 1, arrayI1, updateI0, updateI1, diff);
        updateTree(treeI);
    }


    // calculate

    public int calc(int i0, int i1) {
        return calc(1, 0, size - 1, i0, i1);
    }

    private int calc(int treeI, int arrayI0, int arrayI1, int calcI0, int calcI1) {
        if (calcI0 > calcI1) {
            return switch (type) {
                case SUM -> 0;
                case MIN -> Integer.MAX_VALUE;
                case MAX -> Integer.MIN_VALUE;
                default -> throw new UnsupportedOperationException();
            };
        }

        int treeLeftI = treeI << 1;
        int treeRightI = treeLeftI | 1;

        if (lazy[treeI] != 0) {
            updateTree(treeI, arrayI0, arrayI1, lazy[treeI]);
            // if not leaf - apply lazy update
            if (arrayI0 != arrayI1) {
                lazy[treeLeftI] += lazy[treeI];
                lazy[treeRightI] += lazy[treeI];
            }
            lazy[treeI] = 0;
        }

        if (calcI0 == arrayI0 && calcI1 == arrayI1) {
            return tree[treeI];
        }

        int middle = arrayI0 + (arrayI1 - arrayI0) / 2;
        int leftVal = calc(treeLeftI, arrayI0, middle, calcI0, Math.min(calcI1, middle));
        int rightVal = calc(treeRightI, middle + 1, arrayI1, Math.max(calcI0, middle + 1), calcI1);

        return switch (type) {
            case SUM -> leftVal + rightVal;
            case MIN -> Math.min(leftVal, rightVal);
            case MAX -> Math.max(leftVal, rightVal);
            default -> throw new UnsupportedOperationException();
        };
    }


    private void updateTree(int treeI) {
        int treeLeftI = treeI << 1;
        int treeRightI = treeLeftI | 1;

        tree[treeI] = switch (type) {
            case SUM -> tree[treeLeftI] + tree[treeRightI];
            case MIN -> Math.min(tree[treeLeftI], tree[treeRightI]);
            case MAX -> Math.max(tree[treeLeftI], tree[treeRightI]);
            default -> throw new UnsupportedOperationException();
        };
    }

    private void updateTree(int treeI, int arrayI0, int arrayI1, int diff) {
        tree[treeI] += switch (type) {
            case SUM -> (arrayI1 - arrayI0 + 1) * diff;
            case MIN, MAX -> diff;
            default -> throw new UnsupportedOperationException();
        };
    }

}
