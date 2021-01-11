package week166;

/**
 * @Classname lc1283
 * @Description
 * @Date 2021/1/11 10:54
 * @Created by j-tooyoung
 */
public class lc1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 0x3f3f3f3f;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            int ans = check(nums, mid);
//            System.out.println(ans + " " + mid);
            if (ans > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int check(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            res += (num % mid) == 0 ? num / mid : num / mid + 1;
        }
        return res;
    }

}
