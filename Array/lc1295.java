/**
 * 1295. 统计位数为偶数的数字
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 */
public class lc1295 {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int val : nums) {
            if (isOdd(val)) {
                res++;
            }
        }
        return res;
    }

    private boolean isOdd(int val) {
        int cnt = 0;
        while (val != 0) {
            val /= 10;
            cnt++;
        }
        return (cnt & 1) == 0;
    }
}
