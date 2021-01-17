package week224;

import java.util.*;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5655 {

    public int largestSubmatrix(int[][] matrix) {
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cnt1 = 0;
                int cnt2 = 0;

                for (int i = 0; i < o1.length; i++) {
                    if (o1[i] == 1) {
                        cnt1++;
                    }
                    if (o2[i] == 1) {
                        cnt2++;
                    }
                }
                return cnt1 - cnt2;
            }
        });
        for (int[] arr : matrix) {
            Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
        int res = 0;
        Stack<Integer> st = new Stack<>();

        return 0;
    }
}
