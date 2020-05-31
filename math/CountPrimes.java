import java.util.Arrays;

/**
 * 计算区间素数的个数
 */
public class CountPrimes {

    static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                System.out.println(i+":素数");
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 20; i++) {
            System.out.println(countPrimes(i));
        }
    }
}
