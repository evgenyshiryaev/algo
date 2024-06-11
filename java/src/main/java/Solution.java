import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        int tcs = FastScanner.nextInt();

        for (int tc = 1; tc <= tcs; ++tc) {
            int n = FastScanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = FastScanner.nextInt();
            }

            System.out.println("RESULT");
        }
    }


    private static class FastScanner {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");

        static String nextString() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(nextString());
        }

        static long nextLong() {
            return Long.parseLong(nextString());
        }
    }

}
