package algo;

import java.util.Arrays;

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
//        System.out.println(Arrays.toString(lis));
        return lis;
    }


    // n * logN
    public static int[] lisNlogN(int[] nums) {
        final int N = nums.length;

        final int[] d = new int[N + 1]; // d[i] is last LIS num of length i
        final int[] pos = new int[N + 1]; // index of last element of LIS length i last element
        final int[] prev = new int[N]; // prev[i] is index of prev num to nums[i]
        int length = 0;

        for (int i = 0; i < N; ++ i) {
            int j = Arrays.binarySearch(d, 0, length, nums[i]);
            if (j < 0) {
                j = -(j + 1);
            }

            d[j] = nums[i];
            pos[j] = i;
            prev[i] = j == 0 ? -1 : pos[j - 1];
            if (j == length) {
                ++ length;
            }
        }

        final int[] lis = new int[length --];
        int p = pos[length];
        while (p != -1) {
            lis[length --] = nums[p];
            p = prev[p];
        }
//        System.out.println(Arrays.toString(lis));
        return lis;
    }

}
