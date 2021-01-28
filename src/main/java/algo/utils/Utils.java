package algo.utils;

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

}
