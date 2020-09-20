package Dweek35;

/**
 * @Classname lc5503
 * @Description TODO
 * @Date 2020/9/19 22:33
 * @Created by xp123
 * 5503. 所有奇数长度子数组的和
 * https://leetcode-cn.com/contest/biweekly-contest-35/problems/sum-of-all-odd-length-subarrays/
 */
public class lc5503 {

    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int[] total = new int[len + 1];
        int res = 0;
        for (int i = 0; i < len; i++) {
            total[i + 1] = total[i] + arr[i];
            res += arr[i];
            int j = i-2;
            while (j >= 0) {
                res += (total[i+1] - total[j]);
                j-=3;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 11, 12};
        System.out.println(sumOddLengthSubarrays(arr));

    }
}
