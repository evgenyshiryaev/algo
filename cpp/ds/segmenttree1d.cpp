// http://e-maxx.ru/algo/segment_tree
// https://cp-algorithms.com/data_structures/segment_tree.html
// https://www.hackerearth.com/practice/notes/segment-tree-and-lazy-propagation

#include <assert.h>
#include <vector>

using namespace std;

class SegmentTree1d {

public:
    enum Type {
        SUM, MIN, MAX
    };

private:
    const Type type;
    const size_t size;
    vector<int> tree, lazy;

    void build(size_t treeI, vector<int>& array, size_t arrayI0, size_t arrayI1) {
        if (arrayI0 == arrayI1) {
            tree[treeI] = array[arrayI0];
            return;
        }

        size_t arrayMiddleI = arrayI0 + ((arrayI1 - arrayI0) >> 1);
        build(treeI << 1, array, arrayI0, arrayMiddleI);
        build((treeI << 1) | 1, array, arrayMiddleI + 1, arrayI1);
        updateTree(treeI);
    }

    void update(size_t treeI, size_t arrayI0, size_t arrayI1, size_t updateI0, size_t updateI1, int diff) {
        size_t treeLeftI = treeI << 1;
        size_t treeRightI = treeLeftI | 1;

        if (lazy[treeI]) {
            updateTree(treeI, arrayI0, arrayI1, lazy[treeI]);
            // if not leaf - apply lazy update
            if (arrayI0 != arrayI1) {
                lazy[treeLeftI] += lazy[treeI];
                lazy[treeRightI] += lazy[treeI];
            }
            lazy[treeI] = 0;
        }

        if (arrayI0 > arrayI1 || arrayI0 > updateI1 || arrayI1 < updateI0) return;

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

        size_t arrayMiddleI = arrayI0 + ((arrayI1 - arrayI0) >> 1);
        update(treeLeftI, arrayI0, arrayMiddleI, updateI0, updateI1, diff);
        update(treeRightI, arrayMiddleI + 1, arrayI1, updateI0, updateI1, diff);
        updateTree(treeI);
    }

    void updateTree(size_t treeI) {
        size_t treeLeftI = treeI << 1;
        size_t treeRightI = treeLeftI | 1;

        switch (type) {
        case SUM:
            tree[treeI] = tree[treeLeftI] + tree[treeRightI];
            break;
        case MIN:
            tree[treeI] = min(tree[treeLeftI], tree[treeRightI]);
            break;
        case MAX:
            tree[treeI] = max(tree[treeLeftI], tree[treeRightI]);
            break;
        };
    }

    void updateTree(size_t treeI, size_t arrayI0, size_t arrayI1, int diff) {
        switch (type) {
        case SUM:
            tree[treeI] += (arrayI1 - arrayI0 + 1) * diff;
            break;
        case MIN:
        case MAX:
            tree[treeI] += diff;
        };
    }

    int calc(size_t treeI, size_t arrayI0, size_t arrayI1, size_t calcI0, size_t calcI1) {
        if (calcI0 > calcI1) {
            switch (type) {
            case SUM:
                return 0;
            case MIN:
                return INT_MAX;
            case MAX:
                return INT_MIN;
            };
        }

        size_t treeLeftI = treeI << 1;
        size_t treeRightI = treeLeftI | 1;

        if (lazy[treeI]) {
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

        size_t middle = arrayI0 + (arrayI1 - arrayI0) / 2;
        int leftVal = calc(treeLeftI, arrayI0, middle, calcI0, min(calcI1, middle));
        int rightVal = calc(treeRightI, middle + 1, arrayI1, max(calcI0, middle + 1), calcI1);

        switch (type) {
        case SUM:
            return leftVal + rightVal;
        case MIN:
            return min(leftVal, rightVal);
        case MAX:
            return max(leftVal, rightVal);
        };
    }

public:
    SegmentTree1d(Type _type, vector<int>& array): type(_type), size(array.size()), tree(size << 2), lazy(size << 2) {
        if (size > 0) build(1, array, 0, array.size() - 1);
    }

    void update(size_t i, int diff) {
        update(i, i, diff);
    }

    void update(size_t i0, size_t i1, int diff) {
        update(1, 0, size - 1, i0, i1, diff);
    }

    int calc(size_t i0, size_t i1) {
        return calc(1, 0, size - 1, i0, i1);
    }
};


void sumTest(vector<int>& array);
void minTest(vector<int>& array);
void maxTest(vector<int>& array);

int main() {
    vector<int> array{ 1, 3, -2, 8, -7 };
    sumTest(array);
    minTest(array);
    maxTest(array);
}

void sumTest(vector<int>& array) {
    SegmentTree1d tree(SegmentTree1d::Type::SUM, array);
    // [1, 3, -2, 8, -7]
    assert(1 == tree.calc(0, 0));
    assert(-2 == tree.calc(2, 2));
    assert(-7 == tree.calc(4, 4));
    assert(4 == tree.calc(0, 1));
    assert(1 == tree.calc(1, 2));
    assert(9 == tree.calc(1, 3));
    assert(3 == tree.calc(0, 4));

    tree.update(2, -3);

    // [1, 3, -5, 8, -7]
    assert(1 == tree.calc(0, 0));
    assert(-5 == tree.calc(2, 2));
    assert(-7 == tree.calc(4, 4));
    assert(4 == tree.calc(0, 1));
    assert(-2 == tree.calc(1, 2));
    assert(6 == tree.calc(1, 3));
    assert(0 == tree.calc(0, 4));

    tree.update(1, 3, -2);

    // [1, 1, -7, 6, -7]
    assert(1 == tree.calc(0, 0));
    assert(-7 == tree.calc(2, 2));
    assert(-7 == tree.calc(4, 4));
    assert(2 == tree.calc(0, 1));
    assert(-6 == tree.calc(1, 2));
    assert(0 == tree.calc(1, 3));
    assert(-6 == tree.calc(0, 4));
}

void minTest(vector<int>& array) {
    SegmentTree1d tree(SegmentTree1d::Type::MIN, array);

    // [1, 3, -2, 8, -7]
    assert(1 == tree.calc(0, 0));
    assert(1 == tree.calc(0, 1));
    assert(-2 == tree.calc(0, 2));
    assert(-2 == tree.calc(0, 3));
    assert(-7 == tree.calc(0, 4));
    assert(-2 == tree.calc(1, 3));
    assert(-7 == tree.calc(2, 4));

    tree.update(1, -3);
    tree.update(3, -11);

    // [1, 0, -2, -3, -7]
    assert(1 == tree.calc(0, 0));
    assert(0 == tree.calc(0, 1));
    assert(-2 == tree.calc(0, 2));
    assert(-3 == tree.calc(0, 3));
    assert(-7 == tree.calc(0, 4));
    assert(-3 == tree.calc(1, 3));
    assert(-7 == tree.calc(2, 4));

    tree.update(0, 2, -6);

    // [-5, -6, -8, -3, -7]
    assert(-5 == tree.calc(0, 0));
    assert(-6 == tree.calc(0, 1));
    assert(-8 == tree.calc(0, 2));
    assert(-8 == tree.calc(0, 3));
    assert(-8 == tree.calc(0, 4));
    assert(-8 == tree.calc(1, 3));
    assert(-8 == tree.calc(2, 4));
    assert(-7 == tree.calc(3, 4));
}

void maxTest(vector<int>& array) {
    SegmentTree1d tree(SegmentTree1d::Type::MAX, array);

    // [1, 3, -2, 8, -7]
    assert(1 == tree.calc(0, 0));
    assert(3 == tree.calc(0, 1));
    assert(3 == tree.calc(0, 2));
    assert(8 == tree.calc(0, 3));
    assert(8 == tree.calc(0, 4));
    assert(8 == tree.calc(1, 3));
    assert(8 == tree.calc(2, 4));

    tree.update(0, 3);
    tree.update(4, 17);

    // [4, 3, -2, 8, 10]
    assert(4 == tree.calc(0, 0));
    assert(4 == tree.calc(0, 1));
    assert(4 == tree.calc(0, 2));
    assert(8 == tree.calc(0, 3));
    assert(10 == tree.calc(0, 4));
    assert(8 == tree.calc(1, 3));
    assert(10 == tree.calc(2, 4));

    tree.update(1, 4, 2);

    // [4, 5, 0, 10, 12]
    assert(4 == tree.calc(0, 0));
    assert(5 == tree.calc(0, 1));
    assert(5 == tree.calc(0, 2));
    assert(10 == tree.calc(0, 3));
    assert(12 == tree.calc(0, 4));
    assert(10 == tree.calc(1, 3));
    assert(12 == tree.calc(2, 4));
}
