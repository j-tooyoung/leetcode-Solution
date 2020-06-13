/**
 * 875. 爱吃香蕉的珂珂
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 *
 */
public class lc875 {

    public static int minEatingSpeed(int[] piles, int H) {
        int maxVal = 0;
        for (int i = 0; i < piles.length; i++) {
            maxVal = Math.max(maxVal, piles[i]);
        }
        // l,r 分别每小时吃的速度
        int l = 1, r = maxVal;
        while (l < r) {
            //计算吃的时间
            int spendHour = 0;
            int mid = (l + r) >> 1;
            for (int val : piles) {
//                spendHour += (val % mid == 0) ? val / mid : val / mid + 1;
                spendHour += (val - 1) / mid + 1;       //快多了
            }
            if (spendHour > H) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static int minEatingSpeed1(int[] piles, int H) {
        int maxVal = 0;
        for (int i = 0; i < piles.length; i++) {
            maxVal = Math.max(maxVal, piles[i]);
        }
        // l,r 分别每小时吃的速度
        int l = 1, r = maxVal;
        while (l < r) {
            //计算吃的时间
            int mid = (l + r) >> 1;

            if (!possible(piles, H, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static boolean possible(int[] piles, int h, int mid) {
        int time = 0;
        for (int p : piles) {
            time += (p - 1) / mid + 1;
        }
        return time <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles, 8));
        int[] piles1 = {30,11,23,4,20};
        System.out.println(minEatingSpeed(piles1, 5));
        System.out.println(minEatingSpeed(piles1, 6));
    }

}
