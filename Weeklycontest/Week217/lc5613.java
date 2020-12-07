package Week217;

/**
 * @Classname lc5770
 * @Description
 * @Date 2020/11/22 18:11
 * @Created by j-tooyoung
 */
public class lc5613 {

    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
