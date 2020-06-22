package week194;

/**
 * 5440. 数组异或操作
 * https://leetcode-cn.com/contest/weekly-contest-194/problems/xor-operation-in-an-array/
 */
public class lc5440 {

    public static int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= (start + 2 * i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
