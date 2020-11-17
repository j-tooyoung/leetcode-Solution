package Dweek39;

import java.util.Arrays;

/**
 * @Classname lc5574
 * @Description 5553. 分配重复整数
 * @Date 2020/11/8 22:14
 * @Created by j-tooyoung
 */
public class lc5553 {

    // dp动态规划
    // 考虑到订单数目最多为 1010，故使用状态压缩动态规划解决本题：用一个 0 - 2^{10}(=1024)0−2
    //10
    // (=1024) 的整数代表 mm 个顾客的一个子集。随后，用 dp[i][j]dp[i][j] 表示：\textit{cnt}cnt 数组中的前 ii 个元素，能否满足顾客的子集合 jj 的订单需求。
//    https://leetcode-cn.com/problems/distribute-repeating-integers/solution/zi-ji-mei-ju-jing-dian-tao-lu-zhuang-ya-dp-by-arse/
    public boolean canDistribute1(int[] nums, int[] quantity) {
        int[] cnt = new int[1010];
        for (int num : nums) {
            cnt[num]++;
        }
        Arrays.sort(quantity);
        Arrays.sort(cnt);
        cnt = Arrays.copyOfRange(cnt, cnt.length - 50, cnt.length);
//        Arrays.stream(cnt).forEach(val -> System.out.print(val + " "));
        return false;
    }

    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] cnt = new int[1010];
        for (int num : nums) {
            cnt[num]++;
        }
        Arrays.sort(quantity);
        Arrays.sort(cnt);
        cnt = Arrays.copyOfRange(cnt, cnt.length - 50, cnt.length);
        Arrays.stream(cnt).forEach(val -> System.out.print(val + " "));
        return dfs(cnt, quantity, quantity.length - 1);
    }

    private boolean dfs(int[] cnt, int[] quantity, int idx) {
        if (idx < 0) return true;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= quantity[idx]) {
                cnt[i] -= quantity[idx];
                if (dfs(cnt, quantity, idx - 1)) {
                    return true;
                }
                cnt[i] += quantity[idx];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int x = 10;
        int p = lowbit(x);
        while (p != x) {
            x -= p;
            p = lowbit(x);
        }
        System.out.println();
    }

    static int lowbit(int x) {
        return x & (x - 1);
    }


}
