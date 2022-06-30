package algo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Sort {

    private static final Random RANDOM = ThreadLocalRandom.current();


    // O(n^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++ i) {
            int val = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                -- j;
            }

            arr[j + 1] = val;
        }
    }


    // O(n * log(n))
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] leftArr = new int[middle - left + 2];
        for (int i = 0; i < leftArr.length - 1; ++ i) {
            leftArr[i] = arr[left + i];
        }
        leftArr[leftArr.length - 1] = Integer.MAX_VALUE; // sentinel

        int[] rightArr = new int[right - middle + 1];
        for (int i = 0; i < rightArr.length - 1; ++ i) {
            rightArr[i] = arr[middle + 1 + i];
        }
        rightArr[rightArr.length - 1] = Integer.MAX_VALUE; // sentinel

        int li = 0;
        int ri = 0;
        for (int i = left; i <= right; ++ i) {
            arr[i] = leftArr[li] <= rightArr[ri] ? leftArr[li ++] : rightArr[ri ++];
        }
    }


    // O(n + (max - min))
    public static void countSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        int[] freq = new int[max - min + 1];
        for (int a : arr) {
            ++ freq[a - min];
        }

        int ri = 0;
        for (int i = 0; i < freq.length; ++i) {
            while (freq[i] -- > 0) {
                arr[ri ++] = i + min;
            }
        }
    }


    // O(n * log(n))
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int randI = left + RANDOM.nextInt(right - left + 1);
        int temp = arr[randI];
        arr[randI] = arr[right];
        arr[right] = temp;

        int i = left;

        for (int j = left; j <= right; ++ j) {
            if (arr[j] <= arr[right]) {
                temp = arr[i];
                arr[i ++] = arr[j];
                arr[j] = temp;
            }
        }

        quickSort(arr, left, i - 2);
        quickSort(arr, i, right);
    }


    // O(n)
    public static int quickSelect(int[] arr, int k) {
        return quickSelect(arr, k, 0, arr.length - 1);
    }

    private static int quickSelect(int[] arr, int k, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int randI = left + RANDOM.nextInt(right - left + 1);
        int temp = arr[randI];
        arr[randI] = arr[right];
        arr[right] = temp;

        int i = left;

        for (int j = left; j <= right; ++ j) {
            if (arr[j] <= arr[right]) {
                temp = arr[i];
                arr[i ++] = arr[j];
                arr[j] = temp;
            }
        }

        if (i - 1 == k) {
            return arr[k];
        }

        return i - 1 > k ? quickSelect(arr, k, left, i - 2) : quickSelect(arr, k, i, right);
    }

}
