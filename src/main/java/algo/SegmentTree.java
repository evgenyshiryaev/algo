package algo;


// https://cp-algorithms.com/data_structures/segment_tree.html
public class SegmentTree {

    private int[] t;

    private int[] a;

    private int pos, newVal;


    public void build(int a[]) {
        t = new int[4 * a.length];
        this.a = a;
        build(1, 0, a.length - 1);
    }


    public int sum(int l, int r) {
        return sum(1, 0, a.length - 1, l, r);
    }


    public void update(int pos, int newVal) {
        this.pos = pos;
        this.newVal = newVal;
        update(1, 0, a.length - 1);
    }


    private void build(int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
            return;
        }

        int tm = (tl + tr) / 2;
        int vl = 2 * v;
        int vr = vl + 1;

        build(vl, tl, tm);
        build(vr, tm + 1, tr);

        t[v] = t[vl] + t[vr];
    }


    private int sum(int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == tl && r == tr) {
            return t[v];
        }

        int tm = (tl + tr) / 2;
        int vl = 2 * v;
        int vr = vl + 1;

        return sum(vl, tl, tm, l, Math.min(r, tm))
               + sum(vr, tm + 1, tr, Math.max(l, tm + 1), r);
    }


    private void update(int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = newVal;
            return;
        }

        int tm = (tl + tr) / 2;
        int vl = 2 * v;
        int vr = vl + 1;

        if (pos <= tm) {
            update(vl, tl, tm);
        } else {
            update(vr, tm + 1, tr);
        }

        t[v] = t[vl] + t[vr];
    }

}
