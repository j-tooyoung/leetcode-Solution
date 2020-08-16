package week202;

import org.omg.CORBA.MARSHAL;

import java.util.*;

/**
 * 5490. 吃掉 N 个橘子的最少天数
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/minimum-number-of-days-to-eat-n-oranges/
 */
public class lc5490 {

    // dp 或记忆化搜索
    public static int minDays(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        for (int i = 1; i < n; i++) {
//            int cnt1 = dp[i - 1]+1;
//            int cnt2 = (i % 2 == 0) ? dp[i / 2]+1 : 0;
//            int cnt3 = (i % 3 == 0) ? dp[i- 2* i / 3]+1 : 0;
//            if (cnt2 != 0){
//                dp[i] = Math.min(cnt1, cnt2);
//            }
//            if (cnt3 !=0){
//                dp[i] = Math.min(dp[i], cnt3);
//            }
//        }
//        return dp[n];
        return 0;
    }

    public static int minDays1(int n) {
        int cnt = -1;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (true) {
            int size = q.size();
            ++cnt;
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                if (val == 0) {
                    return cnt;
                }
                if (set.contains(val)) {
                    continue;
                }
                set.add(val);
                if (val % 3 ==0) q.add(val -2 * (val / 3));
                if (val % 2 ==0) q.add(val / 2);
                q.add(val - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minDays(10));
        System.out.println(minDays1(10));
        System.out.println(minDays1(6));
        System.out.println(minDays1(1));
        System.out.println(minDays1(56));

    }
}
