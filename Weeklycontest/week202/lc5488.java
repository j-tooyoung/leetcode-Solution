package week202;

/**
 * 5488. 使数组中所有元素相等的最小操作数
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/minimum-operations-to-make-array-equal/
 */
public class lc5488 {

    public static int minOperations(int n) {
        int mid = n;
        System.out.println(mid);

        int res = 0;
        for (int i = 0; i < (n >> 1); i++) {
            res += (mid - 2 * i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(6));

        for (int i = 0; i < 6; i++) {
            System.out.println(2 * i + 1);
        }
    }

}
