#include <assert.h>
#include <deque>
#include <vector>

using namespace std;


// O(n)
vector<int> getRightGreaters(vector<int>& nums) {
    vector<int> r(nums.size(), -1);
    deque<int> d;
    for (int i = 0; i < nums.size(); ++i) {  // reversed for left
        while (!d.empty() && nums[i] > nums[d.back()]) {  // >= if ge, < if lt
            r[d.back()] = i;
            d.pop_back();
        }
        d.push_back(i);
    }
    return r;
}


// O(n)
vector<int> getIntervalMaxs(vector<int>& nums, int m) {
    vector<int> r(nums.size() - m + 1);
    deque<int> d;

    for (int i = 0; i < m; ++i) {
        while (!d.empty() && nums[i] >= nums[d.back()]) d.pop_back();  // <= for min
        d.push_back(i);
    }
    r[0] = nums[d.front()];

    for (int i = m; i < nums.size(); ++i) {
        if (!d.empty() && d.front() <= i - m) d.pop_front();
        while (!d.empty() && nums[i] >= nums[d.back()]) d.pop_back();  // <= for min
        d.push_back(i);
        r[i - m + 1] = nums[d.front()];
    }

    return r;
}


int main() {
    vector<int> nums({ 10, 1, 6, 2, 4, 1, 4, 9 });

    assert(vector<int>({ -1, 2, 7, 4, 7, 6, 7, -1 }) == getRightGreaters(nums));

    assert(vector<int>({ 10, 1, 6, 2, 4, 1, 4, 9 }) == getIntervalMaxs(nums, 1));
    assert(vector<int>({ 10, 6, 6, 4, 4, 9 }) == getIntervalMaxs(nums, 3));
    assert(vector<int>({ 10, 6, 9 }) == getIntervalMaxs(nums, 6));
    assert(vector<int>({ 10 }) == getIntervalMaxs(nums, 8));

    return 0;
}
