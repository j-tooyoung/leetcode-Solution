package Dweek39;

import java.util.Arrays;

/**
 * @Classname lc5572
 * @Description
 * 5551. 使字符串平衡的最少删除次数
 *
 * @Date 2020/11/8 22:13
 * @Created by j-tooyoung
 */
public class lc5551 {

    public int minimumDeletions(String s) {
        int ans = Integer.MAX_VALUE;
        int[] cnt = new int[s.length() + 1];
        int len = s.length();

        for (int i = 1; i <= len; i++) {
            if (s.charAt(i-1) == 'a') {
                cnt[i] = cnt[i - 1] + 1;
            }else{
                cnt[i] =cnt[i-1];
            }
        }
        // Arrays.stream(cnt).forEach(System.out::print);
        for (int i : cnt) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= len; i++) {
            int left = cnt[i] == 0 ? 0 : (i - cnt[i]);
            int right = (cnt[len] - cnt[i]);
            ans = Math.min(ans, left + right);
        }
        return ans;
    }
}
