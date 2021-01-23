package week171;

/**
 * @Classname lc1317
 * @Description
 * @Date 2021/1/23 14:01
 * @Created by j-tooyoung
 */
public class lc1317 {

    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (int i = 1; i < n; i++) {
            if (isValid(i) && isValid(n - i)) {
                res[0] = i;
                res[1] = n - i;
                break;
            }
        }
        return res;
    }

    boolean isValid(int i) {
        while (i > 0) {
            if (i % 10 == 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
