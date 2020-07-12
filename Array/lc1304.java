import java.util.Arrays;

/**
 * 1304. 和为零的N个唯一整数
 * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class lc1304 {

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int num = n;
        for (int i = 0; i < n; ) {
            if (i + 2 >= n) break;
            res[i] = -num;
            res[i + 1] = num;
            i += 2;
            num--;
        }
        if (n % 2 == 1) {
            res[n - 1] = 0;
        } else {
            res[n - 2] = -num;
            res[n - 1] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(4)));
        System.out.println(Arrays.toString(sumZero(3)));

        for (int i = 1; i < 10; i++) {
            System.out.println(Arrays.toString(sumZero(i)));
        }
    }
}
