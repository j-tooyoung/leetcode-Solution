package Week119;

import java.util.Arrays;

/**
 * @Classname lc976
 * @Description
 * @Date 2021/1/13 12:07
 * @Created by j-tooyoung
 */
public class lc976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int sum = 0;
        for (int i = len - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i-1];
            int c = A[i-2];
            if (b + c > a && a - b < c && a - c < b) {
                return a + b + c;
            }
        }
        return sum;
    }

}
