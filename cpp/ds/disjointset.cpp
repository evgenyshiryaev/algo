// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3843/
// http://e-maxx.ru/algo/dsu

#include <assert.h>
#include <vector>

using namespace std;

class DisjointSet {

private:
    int size;
    vector<int> roots;
    vector<int> ranks; // height of each vertex

public:
    DisjointSet(int _size): size(_size), roots(size), ranks(size) {
        for (int i = 0; i < size; ++i) {
            roots[i] = i;
            ranks[i] = 1;
        }
    }

    int find(int x) {
        if (x == roots[x]) return x;
        return roots[x] = find(roots[x]);
    }

    void unionn(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (ranks[rootX] > ranks[rootY]) roots[rootY] = rootX;
            else if (ranks[rootX] < ranks[rootY]) roots[rootX] = rootY;
            else {
                roots[rootY] = rootX;
                ++ranks[rootX];
            }
            -- size;
        }
    }

    bool connected(int x, int y) {
        return find(x) == find(y);
    }

    int getSize() {
        return size;
    }
};


int main() {
    DisjointSet set(5);

    for (int i = 0; i < 5; ++i) assert(i == set.find(i));
    assert(5 == set.getSize());

    set.unionn(1, 3);
    set.unionn(2, 4);

    assert(set.connected(1, 3));
    assert(set.connected(2, 4));
    assert(!set.connected(1, 2));
    assert(!set.connected(0, 1));
    assert(!set.connected(0, 2));

    assert(3 == set.getSize());

    set.unionn(0, 3);

    assert(set.connected(1, 3));
    assert(set.connected(2, 4));
    assert(!set.connected(1, 2));
    assert(set.connected(0, 1));
    assert(!set.connected(0, 2));

    assert(2 == set.getSize());

    set.unionn(1, 2);

    assert(set.connected(0, 1));
    assert(set.connected(1, 2));
    assert(set.connected(2, 3));
    assert(set.connected(3, 4));
    assert(set.connected(4, 0));

    assert(1 == set.getSize());
}
