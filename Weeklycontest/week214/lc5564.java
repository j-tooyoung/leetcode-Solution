package week214;

/**
 * @Classname lc5564
 * @Description
 * 5564. 通过指令创建有序数组
 * https://leetcode-cn.com/contest/weekly-contest-214/problems/create-sorted-array-through-instructions/
 * @Date 2020/11/8 10:44
 * @Created by j-tooyoung
 */
public class lc5564 {

    int[] arr;
    int n;

    int lowbit(int x) {
        return x & (-x);
    }

    void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) {
            arr[i] += c;
        }
    }

    int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += arr[i];
        }
        return res;
    }

    public int createSortedArray(int[] instructions) {
        long res = 0;
//        int mod = 1000_000_007;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < instructions.length; i++) {
            n = Math.max(instructions[i], n);
        }
        arr = new int[n + 1];

        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];
            int left = query(x - 1);
            int right = i - query(x);
            res += Math.min(left, right);
            add(x, 1);
        }
        return (int) (res% mod);
    }

}
