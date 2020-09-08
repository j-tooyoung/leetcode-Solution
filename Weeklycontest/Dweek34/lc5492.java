package Dweek34;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc5492
 * @Description TODO
 * @Date 2020/9/5 23:01
 * @Created by xp123
 * 5492. 分割字符串的方案数
 * https://leetcode-cn.com/contest/biweekly-contest-34/problems/number-of-ways-to-split-a-string/
 */
public class lc5492 {

    // ""
    public static int numWays(String s) {
        long res = 0;
        int len = s.length();
        long mod = 1000000007;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[i + 1] = cnt[i] + ((s.charAt(i) == '1') ? 1 : 0);
        }
        if (cnt[len] % 3 != 0) return 0;
        int target = cnt[len] / 3;
        int i = 1, j = len - 1;
        long left = 0, right = 0;
        while (i <= len && cnt[i] - cnt[0] < target) {
            i++;
        }
        System.out.println(i);
        while (i <= j && cnt[i] - cnt[0] == target) {
            i++;
            left++;
        }
        while (j >= 0 && cnt[len] - cnt[j] < target) {
            j--;
        }
        System.out.println(j);
        while (j >= i && cnt[len] - cnt[j] == target) {
            j--;
            right++;
        }
        System.out.println(left + " " + right);
        if (left == len - 1) return (int) ( getC(len,3) % mod);
        return (int) ((left * right) % mod);
    }

    private static long getC(int len, int i) {
        long res = 1;
        for (int j = len; j >= len - i + 1; j--) {
            res *= j;
        }
        for (int j = 1; j <= i; j++) {
            res /= j;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(getC(4, 3));
//        System.out.println(getC(5, 3));
        List<String> list = new ArrayList<>();
//        list.add("10101");
//        list.add("1001");
        list.add("0000");
        list.add("00000000"); // 21 8个0，7个空位插2张牌
//        list.add("100100010100110");
        for (String s : list) {
            System.out.println(s + " : " + numWays(s));
        }
    }
}
