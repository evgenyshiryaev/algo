# https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3843/

import dataclasses


@dataclasses.dataclass
class DisjointSet:
    roots: dataclasses.field(default_factory=list)
    ranks: dataclasses.field(default_factory=list)

    def __init__(self, size):
        self.roots = [i for i in range(size)]
        self.ranks = [1] * size

    def find(self, x):
        if x == self.roots[x]:
            return x
        self.roots[x] = self.find(self.roots[x])
        return self.roots[x]

    def union(self, x, y):
        root_x, root_y = self.find(x), self.find(y)
        if root_x == root_y:
            return

        if self.ranks[root_x] > self.ranks[root_y]:
            self.roots[root_y] = root_x
        elif self.ranks[root_x] < self.ranks[root_y]:
            self.roots[root_x] = root_y
        else:
            self.roots[root_y] = root_x
            self.ranks[root_x] += 1

    def connected(self, x, y):
        return self.find(x) == self.find(y)


if __name__ == '__main__':
    _ds = DisjointSet(5)
    for _i in range(5):
        assert _i == _ds.find(_i)

    _ds.union(1, 3)
    _ds.union(2, 4)
    assert _ds.connected(1, 3)
    assert _ds.connected(2, 4)
    assert not _ds.connected(1, 2)
    assert not _ds.connected(0, 1)
    assert not _ds.connected(0, 2)

    _ds.union(0, 3)
    assert _ds.connected(1, 3)
    assert _ds.connected(2, 4)
    assert not _ds.connected(1, 2)
    assert _ds.connected(0, 1)
    assert not _ds.connected(0, 2)

    _ds.union(1, 2)
    assert _ds.connected(1, 3)
    assert _ds.connected(2, 4)
    assert _ds.connected(1, 2)
    assert _ds.connected(0, 1)
    assert _ds.connected(0, 2)
