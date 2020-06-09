/**
 * 面试题46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class lc46_1 {

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum(25));
    }
}
