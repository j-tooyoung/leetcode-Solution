/**
 * 面试题 17.06. 2出现的次数
 * https://leetcode-cn.com/problems/number-of-2s-in-range-lcci/
 *
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 */
public class lc17_06 {

    // 动态规划
    public int numberOf2sInRange(int n) {

        return 0;
    }

    // brute force
    public int numberOf2sInRange1(int n) {
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            cnt += bitOf2(i);
        }
        return cnt;
    }

    private int bitOf2(int i) {
        int cnt = 0;
        while (i != 0) {
            if (i % 10 == 2) {
                cnt++;
            }
            i /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }

}
