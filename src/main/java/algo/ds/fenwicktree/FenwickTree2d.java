package algo.ds.fenwicktree;

// Fenwick tree (binary indexed tree) for 2d sum.
// http://e-maxx.ru/algo/fenwick_tree
public class FenwickTree2d {

    private int[][] tree;


    public void build(int sizeY, int sizeX) {
        tree = new int[sizeY][sizeX];
    }

    public void build(int[][] array) {
        build(array.length, array[0].length);
        for (int y = 0; y < array.length; ++ y) {
            for (int x = 0; x < array[0].length; ++ x) {
                inc(y, x, array[y][x]);
            }
        }
    }


    public void inc(int indexY, int indexX, int delta) {
        for (int y = indexY; y < tree.length; y = y | (y + 1)) {
            for (int x = indexX; x < tree[0].length; x = x | (x + 1)) {
                tree[y][x] += delta;
            }
        }
    }


    public int sum(int indexY, int indexX) {
        int result = 0;
        for (int y = indexY; y >= 0; y = (y & (y + 1)) - 1) {
            for (int x = indexX; x >= 0; x = (x & (x + 1)) - 1) {
                result += tree[y][x];
            }
        }
        return result;
    }

}
