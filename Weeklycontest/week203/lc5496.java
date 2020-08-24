package week203;

import java.util.Arrays;

/**
 * 5496. 你可以获得的最大硬币数目
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/maximum-number-of-coins-you-can-get/
 */
public class lc5496 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        int len = piles.length;
        int cnt = len / 3;
        for (int i = len - 2; i >= 0; i -= 2) {
            res += piles[i];
            cnt--;
            if (cnt ==0) break;
            System.out.println(piles[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
