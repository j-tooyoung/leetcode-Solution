package week205;

/**
 * @Classname lc5509
 * @Description TODO
 * @Date 2020/9/6 10:34
 * @Created by xp123
 * 5509. 避免重复字母的最小删除成本
 * https://leetcode-cn.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
public class lc5509 {

    public static int minCost(String s, int[] cost) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 0;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + cost[i];
            System.out.println(sum[i+1]);
        }

        for (int i = 0; i  < len; ) {
            int maxVal = Integer.MIN_VALUE;
            int j = i;
            while (j + 1 < len && chars[j] == chars[j + 1]) {
                maxVal = Math.max(maxVal, cost[j]);
                maxVal = Math.max(maxVal, cost[j + 1]);
                j++;
            }
            if (maxVal != Integer.MIN_VALUE ) {
                res += i >= 1 ? sum[j + 1] - sum[i ] : sum[j + 1] -sum[0];
//                System.out.println(j + " " + (i - 1));
//                System.out.println(sum[j +1] + " " + sum[i]);
//                System.out.println(res);
            }
            if (maxVal != Integer.MIN_VALUE) res -= maxVal;
            i = j + 1;
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(100000 * 100000);
        String s = "aabaaa";
        String s1 = "abaac";
        int[] arr = {1, 2, 3, 4, 1, 5};
        int[] arr2 = {1, 2, 3, 4,  5};
//        System.out.println(minCost(s, arr));
        System.out.println(minCost(s1, arr2));
    }
}
