/**
 * 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 *
 */
public class lc201 {

    //    我们通过右移，将两个数字压缩为它们的公共前缀。在迭代过程中，我们计算执行的右移操作数。
//    将得到的公共前缀左移相同的操作数得到结果。
    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    // 暴力法过不了
    public static int rangeBitwiseAnd1(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1,100));
    }
}
