package algo;

public class CountSort {

    public static void countSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a < min) {
                min = a;
            }
            if (a > max) {
                max = a;
            }
        }

        int[] freq = new int[max - min + 1];
        for (int a : arr) {
            ++ freq[a - min];
        }

        int ri = 0;
        for (int i = 0; i < freq.length; ++i) {
            while (freq[i] > 0) {
                -- freq[i];
                arr[ri ++] = i + min;
            }
        }
    }

}
