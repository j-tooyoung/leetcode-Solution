package Dweek34;

import java.util.LinkedList;

/**
 * @Classname lc5493
 * @Description TODO
 * @Date 2020/9/5 23:14
 * @Created by xp123
 * 5493. 删除最短的子数组使剩余数组有序
 * https://leetcode-cn.com/contest/biweekly-contest-34/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 */
public class lc5493 {

    // [13,0,14,7,18,18,18,16,8,15,20]  8
    // [2,1]  1
    public int findLengthOfShortestSubarray(int[] arr) {
        LinkedList<Integer> st1 = new LinkedList<>();
        LinkedList<Integer> st2 = new LinkedList<>();
        int len = arr.length;
        st1.addLast(Integer.MIN_VALUE);
        int i = 0, j = len - 1;
        while (i < len && arr[i] >= st1.getLast()) {
            st1.addLast(arr[i++]);
        }

        st2.addLast(Integer.MAX_VALUE);
        while (j >= 0 && arr[j] <= st2.getLast()) {
            st2.addLast(arr[j--]);
        }
        //
        if (i > j + 1) {
            return 0;
        }
        int left = i -1;
        int right = j + 1;
        if (st1.getLast() <= st2.getLast()) {
            return j - i + 1;
        } else if (st1.getLast() > st2.getLast()) {
            while (left >= 0 && arr[left] > st2.getLast()) {
                left--;
            }
            while (right < len && arr[right] < st1.getLast()) {
                right++;
            }
        }
        return Math.min(j - left, right - i);
    }

}
