package week224;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5243 {

    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int len = nums.length ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = len - 1; j >= 0; j--) {
                for (int k = i + 1; k +1< j; k++) {
                    if (nums[i] * nums[j] % nums[k] == 0  ) {
                        int tar = nums[i] * nums[j] / nums[k];
                        if (map.getOrDefault(tar, -1) < j && map.getOrDefault(tar,-1) >k) {
//                            System.out.println(i + " " + j + " " + k + " " + map.get(nums[i] * nums[j] / nums[k]));
                            res += 4;
                        }

                    }
                }
            }
        }
        return res;

//        int lo = 0, hi = nums.length - 1;
//        while (lo + 3 <= hi) {
//            int a = nums[lo], d = nums[hi];
//            for (int i = lo + 1; i < hi; i++) {
//                if (a * d % nums[i] == 0 && map.containsKey(a * d / nums[i])) {
//                    res++;
//                }
//            }
//            res *= 2;
//        }
    }

}
