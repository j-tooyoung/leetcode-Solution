/**
 * @Classname lc1437
 * @Description TODO
 * @Date 2020/8/25 20:37
 * @Created by xp123
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 */
public class lc1437 {

    public boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        int prev = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                ++cnt;
                if (cnt >= 2) {
                    if (i - prev - 1 < k) {
                        return false;
                    }
                    prev = i;
                }
            }
        }
        return true;
    }
}
