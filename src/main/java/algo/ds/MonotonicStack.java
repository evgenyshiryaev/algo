package algo.ds;

import java.util.Arrays;


public class MonotonicStack {

    // O(n)
    public static int[] getRightGreaters(int[] nums) {
        int N = nums.length;

        int[] s = new int[N];
        int si = 0;

        int[] greaters = new int[N];
        Arrays.fill(greaters, -1);

        for (int i = 0; i < N; ++ i) {
            int num = nums[i];
            while (si > 0 && num > nums[s[si - 1]]) {
                greaters[s[-- si]] = i;
            }
            s[si ++] = i;
        }

        return greaters;
    }


    // O(n)
    public static int[] getIntervalMaxs(int[] nums, int m) {
        int N = nums.length;

        int[] s = new int[N];
        int si = 0;
        int sj = 0;

        int[] maxs = new int[N - m + 1];

        for (int i = 0; i < m; ++ i) {
            while (si < sj && nums[i] >= nums[s[sj - 1]]) {
                -- sj;
            }
            s[sj ++] = i;
        }
        maxs[0] = nums[s[si]];

        for (int i = m; i < N; ++ i) {
            while (si < sj && s[si] <= i - m) {
                ++ si;
            }
            while (si < sj && nums[i] >= nums[s[sj - 1]]) {
                -- sj;
            }
            s[sj ++] = i;

            maxs[i - m + 1] = nums[s[si]];
        }

        return maxs;
    }

}
