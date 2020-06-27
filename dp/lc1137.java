/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class lc1137 {

    public static int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        while (n-- > 0) {
            System.out.println(n);
            int tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(3));
//        System.out.println(tribonacci(4));

    }
}
