package week106;

import java.util.*;

/**
 * @Classname lc923
 * @Description
 * @Date 2021/1/2 15:55
 * @Created by j-tooyoung
 */
public class lc923 {

    public int threeSumMulti(int[] A, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int res = 0;
        int len = A.length;

        for (int i = 0; i < len; i++) {
            int T = target - A[i];
            int j = i + 1, k = len - 1;

            while (j < k) {
                int sum = A[j] + A[k];
                if (T < sum) {
                    k--;
                } else if (T > sum) {
                    j++;
                } else {
                    if (A[j] != A[k]) {
                        int left = 1;
                        int right = 1;
                        while (j + 1 < len && A[j] == A[j + 1]) {
                            left++;
                            j++;
                        }
                        while (k-1 > j && A[k] == A[k - 1]) {
                            right++;
                            k--;
                        }
                        res += left * right;
                        res %= mod;
                        j++;
                        k--;
                    } else {
                        res += (k-j+1) *(k-j) /2;
                        res %= mod;

                        break;
                    }
                }
            }

        }
        return res;

    }

//        int i = 0, j = A.length - 1;
//        while (i < j) {
//            int sum = A[i] + A[j];
//            // System.out.println(sum +" "+ map.getOrDefault(target - sum,0));
//
//            if (sum > target) {
//                j--;
//            } else if (sum <= target) {
//                if (target - sum == A[i]) {
//                    res += map.get(A[i]) > 1 ? map.get(A[i]) - 1 : 0;
//                } else if (target - sum == A[j]) {
//                    // System.out.println(map.get(A[j]));
//                    res += map.get(A[j]) > 1 ? map.get(A[j]) - 1 : 0;
//                } else if (target - sum != A[i] || target - sum != A[j]) {
//                    res += map.getOrDefault(target - sum, 0);
//                }
//                res %= mod;
//                i++;
//            }
//        }
//        if (target % 3 == 0 && map.getOrDefault(target / 3, 0) >= 3) {
//            int cnt = map.get(target / 3);
//            res += cnt * (cnt - 1) * (cnt - 2) / 6;
//            res %= mod;
//        }


}
