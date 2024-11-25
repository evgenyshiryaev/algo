// https://leetcode.com/discuss/study-guide/2166045/line-sweep-algorithms

#include <assert.h>
#include <map>
#include <vector>

using namespace std;

using int2 = tuple<int, int>;


// [start, end)
int sweepLine1d(vector<int2>& intervals) {
    map<int, int> m;
    for (auto [start, end] : intervals) ++m[start], --m[end];

    int r = 0, cur = 0;
    for (auto& e : m) cur += e.second, r = max(r, cur);
    return r;
}


int main() {
    vector<int2> v {{0, 10}, {5, 7}, {1, 5}, {3, 9}};
    assert(3 == sweepLine1d(v));

    return 0;
}
