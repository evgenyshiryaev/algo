package algo.ds;

import java.util.Arrays;

public class MonotonicStack {

    public static int[] getMax(int[] nums) {
        int N = nums.length;

        int[] s = new int[N];
        int si = 0;

        int[] max = new int[N];
        Arrays.fill(max, -1);

        for (int i = 0; i < N; ++ i) {
            int num = nums[i];
            while (si > 0 && num > nums[s[si - 1]]) {
                max[s[-- si]] = i;
            }
            s[si ++] = i;
        }

        return max;
    }

}
