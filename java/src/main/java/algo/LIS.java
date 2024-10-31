package algo;

/**
 * Longest Increasing Subsequence.
 * <br>See https://leetcode.com/problems/longest-increasing-subsequence/.
 * 
 */
public class LIS {

    // n ^ 2
    public static int[] lisN2(int[] nums) {
        final int N = nums.length;

        final int[] d = new int[N]; // d[i] is LIS length ending with nums[i]
        final int[] prev = new int[N]; // prev[i] is index of prev num to nums[i]

        for (int i = 0; i < N; ++ i) {
            d[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; ++ j) {
                if (nums[i] > nums[j] && d[j] + 1 >= d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int length = 0;
        int pos = -1;
        for (int i = 0; i < N; ++ i) {
            if (d[i] >= length) {
                length = d[i];
                pos = i;
            }
        }

        final int[] lis = new int[length --];
        while (pos != -1) {
            lis[length --] = nums[pos];
            pos = prev[pos];
        }
        return lis;
    }


    // n * logN
    public static int[] lisNlogN(int[] nums) {
        final int N = nums.length;

        final int[] d = new int[N]; // d[i] is last LIS num of length i+1
        final int[] pos = new int[N]; // index of last element of LIS length i last element
        final int[] prev = new int[N]; // prev[i] is index of prev num to nums[i]
        int length = 0;

        for (int i = 0; i < N; ++ i) {
            int l = 0;
            int r = length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[i] > d[m]) { // >= if non-decreasing sequence
                    l = m + 1;
                } else {
                    r = m;
                }
            }


            d[l] = nums[i];
            pos[l] = i;
            prev[i] = l == 0 ? -1 : pos[l - 1];
            if (l == length) {
                ++ length;
            }
        }

        final int[] lis = new int[length --];
        int p = pos[length];
        while (p != -1) {
            lis[length --] = nums[p];
            p = prev[p];
        }
        return lis;
    }

}
