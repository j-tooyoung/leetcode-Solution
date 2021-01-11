package week166;

/**
 * @Classname lc1281
 * @Description
 * @Date 2021/1/11 10:29
 * @Created by j-tooyoung
 */
public class lc1281 {
    public int subtractProductAndSum(int n) {
        long multi = 1;
        long sum = 0;
        while (n != 0) {
            int mod = n % 10;
            sum += mod;
            multi *= mod;
            n /= 10;
        }
        return (int) (multi - sum);
    }
}
