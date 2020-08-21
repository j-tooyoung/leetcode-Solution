/**
 * 面试题 17.19. 消失的两个数字
 * https://leetcode-cn.com/problems/missing-two-lcci/
 */
public class lc17_19 {

    public int[] missingTwo(int[] nums) {
        int[] res = new int[2];
        int[] cnt = new int[30001];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]] = 1;
        }
        int idx = 0;
        for (int i = 1; i < 30001; i++) {
            if (cnt[i] == 0) {
                res[idx++] = i;
                if (idx >= 2) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
