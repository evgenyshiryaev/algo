#include <assert.h>
#include <vector>

using namespace std;


// https://leetcode.com/problems/longest-increasing-subsequence
// n * logN
vector<int> lis(vector<int>& nums) {
    int N = nums.size();

    // to get LIS length
    vector<int> d(N); // d[i] is last LIS num of length i+1
    int length = 0;

    // to restore longest LIS
    vector<int> pos(N); // index of last element of LIS length i last element
    vector<int> prev(N); // prev[i] is index of prev num to nums[i]

    for (int i = 0; i < N; ++i) {
        int l = 0, r = length;
        while (l < r) {
            int m = l + (r - l) / 2;
            // >= if non-decreasing sequence
            if (nums[i] > d[m]) l = m + 1; else r = m;
        }

        d[l] = nums[i];
        pos[l] = i;
        prev[i] = l == 0 ? -1 : pos[l - 1];
        if (l == length) ++length;
    }

    vector<int> lis(length --);
    int p = pos[length];
    while (p != -1) {
        lis[length--] = nums[p];
        p = prev[p];
    }
    return lis;
}


int lis_main() {
    vector<int> nums = {10, 9, 2, 5, 3, 7, 101, 18};
    assert(lis(nums) == vector<int>({2, 3, 7, 18}));

    nums = {1, 2, 3};
    assert(lis(nums) == vector<int>({1, 2, 3}));

    nums = { 3, 2, 1, 1 };
    assert(lis(nums) == vector<int>({1}));

    return 0;
}