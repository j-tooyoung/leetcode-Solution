package week215;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc5569
 * @Description 5602. 将 x 减到 0 的最小操作数
 * @Date 2020/11/8 22:13
 * @Created by j-tooyoung
 */
public class lc5602 {

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total== x) return len;
        if (total < x) return -1;

        // System.out.println(total);
        map.put(0, 0);

        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
            map.put(sum[i + 1], i);
        }
        for (int i = 0; i <= len; i++) {
            int target = total - x + sum[i];
            if (map.containsKey(target)) {
                ans = Math.min(ans, target == 0 ? len - 1 - map.get(target) : i -1 + len - map.get(target));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

        // fixme bugs 只遍历一次
//        for (int i = 0; i < len; i++) {
//            sum[i + 1] = sum[i] + nums[i];
//            int target = x - total + sum[i + 1];
//            if (map.containsKey(target)) {
//                if (target == sum[i + 1]) {
//                    ans = Math.min(ans, len - i + 1);
//                } else {
//                    ans = Math.min(ans, len - i + map.get(target));
//                }
//                System.out.println(target + " " + map.get(target));
//            }
//            map.put(sum[i + 1], i);
//        }
//        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    int ans = Integer.MAX_VALUE;
    int[][] memo;

    Map<Integer, Integer> map ;
    static int N = (int) 10e5 + 10;
    public int minOperations1(int[] nums, int x) {
        //空间不够
        map = new HashMap<>();
        memo = new int[nums.length + 1][nums.length + 1];
        return dfs(nums, 0, nums.length - 1, x, 0);
    }

    private int dfs(int[] nums, int start, int end, int target, int cnt) {
        if (start > end + 1 || start >= nums.length) {
            return -1;
        }
        if (target < 0) return -1;
        int num = start * 10 + end;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        if (target == 0) {
            ans = Math.min(ans, cnt);
            return ans;
        }
        map.put((start + 1) * N + end, dfs(nums, start + 1, end, target - nums[start], cnt + 1));
        if (end >= 1) {
            map.put(start * N + end - 1, dfs(nums, start, end - 1, target - nums[end], cnt + 1));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs1(int[] nums, int start, int end, int target, int cnt) {
        if (start > end + 1 || start >= nums.length) {
            return -1;
        }
        if (target < 0) return -1;
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        if (target == 0) {
            ans = Math.min(ans, cnt);
        }
        memo[start + 1][end] = dfs(nums, start + 1, end, target - nums[start], cnt + 1);
        if (end >= 1) {
            memo[start][end - 1] = dfs(nums, start, end - 1, target - nums[end], cnt + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
