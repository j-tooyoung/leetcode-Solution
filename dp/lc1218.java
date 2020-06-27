import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class lc1218 {

    public static int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        int[] dp = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[i] - arr[j] == difference) {
//                    dp[i] = max(dp[i], dp[j] + 1);
//                }
//            }
//        }

        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i] - difference)) {
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            } else {
                dp[i] = 1;
            }
            map.put(arr[i], i);
//            System.out.println(dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {1,5,7,8,5,3,4,2,1};
        System.out.println(longestSubsequence(arr, 1));
        System.out.println(longestSubsequence(arr1, 1));
        System.out.println(longestSubsequence(arr2, -2));

    }
}
