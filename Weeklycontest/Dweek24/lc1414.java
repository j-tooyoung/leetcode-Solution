package Dweek24;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc1414
 * @Description
 * @Date 2021/1/12 17:42
 * @Created by j-tooyoung
 */
public class lc1414 {

    public int findMinFibonacciNumbers(int k) {
        int[] dp = new int[30];
        List<Integer> list = new ArrayList<>();
        int a = 1, b = 1;
        int limit = (int) 10e9;
        while (a <= k) {
            list.add(a);
            int sum = a + b;
            a = b;
            b = sum;
        }
        int res = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            if (k >= list.get(i)) {
                ++res;
                k -= list.get(i);
            }
        }
        return res;
// 二分亦可
//        while (k > 0) {
//            int lo = 0, hi = list.size()-1;
//            while (lo < hi) {
//                int mid = lo + hi+1 >> 1;
//                if (list.get(mid) <= k) {
//                    lo = mid;
//                } else {
//                    hi = mid-1;
//                }
//            }
//            k -= list.get(lo);
//            res++;
//
//            if(k ==0) return res;
//        }
//        return res;
    }
}
