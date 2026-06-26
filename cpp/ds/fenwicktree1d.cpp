// http://e-maxx.ru/algo/fenwick_tree

#include <assert.h>
#include <vector>

using namespace std;

class FenwickTree1d {

public:
    enum Type {
        SUM, MIN, MAX
    };

private:
    const Type type;
    vector<int> tree;

public:

    FenwickTree1d(Type _type, int size): type(_type), tree(size) {
        switch (type) {
        case MIN:
            fill(tree.begin(), tree.end(), INT_MAX);
            break;
        case MAX:
            fill(tree.begin(), tree.end(), INT_MIN);
            break;
        }
    }

    FenwickTree1d(Type _type, vector<int>& array): FenwickTree1d(_type, array.size()) {
        for (size_t i = 0; i < array.size(); ++ i)
            update(i, array[i]);
    }

    // for SUM - diff (any delta)
    // for MIN - new value (only decr)
    // for MAX - new value (only incr)
    void update(size_t index, int value) {
        for (size_t i = index; i < tree.size(); i = i | (i + 1))
            switch (type) {
            case SUM:
                tree[i] += value;
                break;
            case MIN:
                tree[i] = min(tree[i], value);
                break;
            case MAX:
                tree[i] = max(tree[i], value);
                break;
            }
    }

    int calc(size_t right) {
        int res;
        switch (type) {
        case SUM:
            res = 0;
            for (int i = right; i >= 0; i = (i & (i + 1)) - 1)
                res += tree[i];
            return res;
        case MIN:
            res = INT_MAX;
            for (int i = right; i >= 0; i = (i & (i + 1)) - 1)
                res = min(res, tree[i]);
            return res;
        case MAX:
            res = INT_MIN;
            for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
                res = max(res, tree[i]);
            }
            return res;
        }
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
    FenwickTree1d tree(FenwickTree1d::Type::SUM, array);
    // [1, 3, -2, 8, -7]
    assert(1 == tree.calc(0));
    assert(4 == tree.calc(1));
    assert(3 == tree.calc(4));

    tree.update(2, -3);

    // [1, 3, -5, 8, -7]
    assert(1 == tree.calc(0));
    assert(4 == tree.calc(1));
    assert(0 == tree.calc(4));
}

void minTest(vector<int>& array) {
    FenwickTree1d tree(FenwickTree1d::Type::MIN, array);

    // [1, 3, -2, 8, -7]
    assert(1 == tree.calc(0));
    assert(1 == tree.calc(1));
    assert(-2 == tree.calc(2));
    assert(-2 == tree.calc(3));
    assert(-7 == tree.calc(4));

    tree.update(1, 0);
    tree.update(3, -3);

    // [1, 0, -2, -3, -7]
    assert(1 == tree.calc(0));
    assert(0 == tree.calc(1));
    assert(-2 == tree.calc(2));
    assert(-3 == tree.calc(3));
    assert(-7 == tree.calc(4));
}

void maxTest(vector<int>& array) {
    FenwickTree1d tree(FenwickTree1d::Type::MAX, array);

    // [1, 3, -2, 8, -7]
    assert(1 == tree.calc(0));
    assert(3 == tree.calc(1));
    assert(3 == tree.calc(2));
    assert(8 == tree.calc(3));
    assert(8 == tree.calc(4));

    tree.update(0, 4);
    tree.update(4, 10);

    // [4, 3, -2, 8, 10]
    assert(4 == tree.calc(0));
    assert(4 == tree.calc(1));
    assert(4 == tree.calc(2));
    assert(8 == tree.calc(3));
    assert(10 == tree.calc(4));
}
