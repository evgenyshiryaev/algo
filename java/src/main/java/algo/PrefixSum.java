package algo;

public class PrefixSum {

    public static int[] prefixSum1D(int[] nums) {
        final int[] result = new int[nums.length + 1];

        for (int i = 0; i < nums.length; ++ i) {
            result[i + 1] = result[i] + nums[i];
        }

        return result;
    }


    public static int getSum1D(int[] sums, int from, int to) {
        return sums[to + 1] - sums[from];
    }


    public static int[][] prefixSum2D(int[][] nums) {
        final int Y = nums.length;
        final int X = nums[0].length; 

        int[][] result = new int[Y + 1][X + 1];

        for (int y = 0; y < Y; ++ y) {
            int ySum = 0;
            for (int x = 0; x < X; ++ x) {
                ySum += nums[y][x];
                result[y + 1][x + 1] = result[y][x + 1] + ySum;
            }
        }

        return result;
    }


    public static int getSum2D(int[][] sums, int fromY, int fromX, int toY, int toX) {
        return sums[toY + 1][toX + 1]
                - sums[fromY][toX + 1] - sums[toY + 1][fromX]
                + sums[fromY][fromX];
    }

}
