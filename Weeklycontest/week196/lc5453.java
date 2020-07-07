package week196;

import java.util.Arrays;

/**
 * 5453. 所有蚂蚁掉下来前的最后一刻
 * https://leetcode-cn.com/contest/weekly-contest-196/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
public class lc5453 {

    public static int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        if (left.length == 0) return n - right[0];
        if (right.length == 0) return left[left.length - 1];
        //最左 最右到达中点后返回
        int maxLeft = left[left.length - 1];
        int minRight = right[0];
//        int mid = maxLeft + minRight  >> 1;
        double mid = (maxLeft + minRight)/ 2.0;
//        System.out.println((4 + 5) / 2);
        double leftTime = (maxLeft - mid) *2  + n - maxLeft;
        double rightTime = (mid - minRight) * 2 + minRight - 0;
//        System.out.println(leftTime + " " + rightTime);

        return (int) Math.max(leftTime, rightTime);
    }

    public static void main(String[] args) {
        int[] left = {5};
        int[] right = {4};
        System.out.println(getLastMoment(9, left, right));

    }

}
