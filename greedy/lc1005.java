import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * 1005. K 次取反后最大化的数组和
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class lc1005 {

    public static int largestSumAfterKNegations(int[] A, int K) {
        int res = 0;
//        while (K > 0) {
//            Arrays.sort(A);
//            A[0] = -A[0];
////            System.out.println(K);
//            K--;
//        }
//
//        for (int val : A) {
//            res += val;
//        }
        return res;
//        return Arrays.stream(A).sum();
    }


    public static void main(String[] args) {
        int[] A = {4,2,3};
        int[] A1 = {3,-1,0,2};
        int[] A2 = {2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations(A, 1));
        System.out.println(largestSumAfterKNegations(A, 3));
        System.out.println(largestSumAfterKNegations(A, 2));
    }

}
