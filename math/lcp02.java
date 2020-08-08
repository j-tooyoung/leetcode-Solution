import java.util.Arrays;

/**
 * LCP 02. 分式化简
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 */
public class lcp02 {

    public static int[] fraction(int[] cont) {
        // 分母，分子
        int len = cont.length;
        int denominator = cont[len - 1];
        int numerator = 1;
        for (int i = cont.length - 1; i > 0; i--) {
            numerator = cont[i - 1] * denominator + numerator;
            int tmp = denominator;
            denominator = numerator;
            numerator = tmp;
        }
        // 最后一次分母颠倒了
        return new int[]{denominator,numerator};
    }

    public static void main(String[] args) {
        int[] cont = {3, 2, 0, 2};
        int[] cont1 = {0, 0, 2};
        System.out.println(Arrays.toString(fraction(cont)));
        System.out.println(Arrays.toString(fraction(cont1)));

    }

}
