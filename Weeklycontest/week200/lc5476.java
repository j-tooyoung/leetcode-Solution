package week200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 5476. 找出数组游戏的赢家
 * https://leetcode-cn.com/contest/weekly-contest-200/problems/find-the-winner-of-an-array-game/
 */
public class lc5476 {

    public static int getWinner(int[] arr, int k) {
        int len = arr.length;
        LinkedList<Integer> list = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            list.addLast(arr[i]);
            ans = Math.max(arr[i], ans);
        }
        int last = arr[0];
        int cnt = 0;
        if (k > len) return ans;
        while (true) {
            int first = list.removeFirst();
            int second = list.removeFirst();
            int max = Math.max(first, second);
            list.addLast(Math.min(first, second));
            list.addFirst(max);
//            cnt = (max == last) ? cnt++ : 1;
            cnt = (max == last) ? ++cnt: 1;
            last = max;
            if (cnt == k) {
                return last;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        int[] arr1 = {1,11,22,33,44,55,66,77,88,99};
        System.out.println(getWinner(arr, 2));
        System.out.println(getWinner(arr1, 1000000000));
    }

}
