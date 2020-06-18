package week193;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 5438. 制作 m 束花所需的最少天数
 * https://leetcode-cn.com/contest/weekly-contest-193/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class lc5438 {

    // 二分
    public static int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) return -1;
        return 0;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
//        System.out.println(minDays(bloomDay, 3, 1));
//        System.out.println(minDays(bloomDay, 3, 2));
        int[] bloomDay1 = {7,7,7,7,12,7,7};
        System.out.println(minDays(bloomDay1, 2, 3));
        int[] bloomDay2 = {1000000000,1000000000};
        System.out.println(minDays(bloomDay2, 1, 1));
        int[] bloomDay3 = {1,10,2,9,3,8,4,7,5,6};
        System.out.println(minDays(bloomDay3, 4, 2));
    }

}
