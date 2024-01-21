package algo.utils;

import java.util.Arrays;
import java.util.Collection;


public class Utils {

    public static int[] toArray(Collection<Integer> list) {
        int[] result = new int[list.size()];

        int i = 0;
        for (int n : list) {
            result[i ++] = n;
        }

        return result;
    }


    public static void print(Collection<int[]> list) {
        for (int[] a : list) {
            System.out.print(Arrays.toString(a));
            System.out.print(", ");
        }
        System.out.println();
    }

}
