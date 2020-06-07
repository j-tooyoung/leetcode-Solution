/**
 *
 */
public class minCount {

    public static int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            res += coins[i] % 2 == 0 ? coins[i] / 2 : coins[i] / 2 + 1;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
