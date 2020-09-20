package fallContest2020;

import java.util.Arrays;

/**
 * 2. 早餐组合
 */
public class c2 {

    public static int breakfastNumber2(int[] staple, int[] drinks, int x) {
        int res = 0;
        int mod = 1000000007;

        Arrays.sort(drinks);
        Arrays.sort(staple);
        int last = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            while (last >= 0 && staple[i] + drinks[last] > x) last--;
            res = (res + last + 1) % mod;
        }
        return res;

//        return (int) (res % mod);
    }

    //
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int res = 0;
        int mod = 1000000007;

        Arrays.sort(drinks);
        int lenDrink = drinks.length;
        for (int i = 0; i < staple.length; i++) {
            int idx = bs(x - staple[i], drinks);
            res += idx % mod;
            res %= mod;
        }
        return res;

//        return (int) (res % mod);
    }

    private static int bs(int target, int[] drinks) {
        int i = 0, j = drinks.length;
        while (i < j) {
            int mid = i + j >> 1;
            if (drinks[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    // 暴力法
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {
        long res = 0;
        int mod = 1000000007;
//        Arrays.sort(staple);
//        Arrays.sort(drinks);
        for (int i = 0; i < staple.length; i++) {
            for (int j = 0; j < drinks.length; j++) {
                if (staple[i] + drinks[i] <= x) {
                    res++;
                }
            }
        }
        return (int) res % mod;
    }

    public static void main(String[] args) {
        int[] drinks = {8, 9, 5, 1};
        int[] drinks2 = {5, 5, 2};
        int[] staple = {10, 20, 5};

//        System.out.println(breakfastNumber(staple,drinks,15));
        Arrays.sort(drinks);
        Arrays.sort(drinks2);
////        Arrays.
        System.out.println(bs(5, drinks2));
        System.out.println(bs(10, drinks2));
//        System.out.println(bs(9, drinks2));
//        System.out.println(bs(9, drinks));
//        System.out.println(bs(0, drinks));
//        System.out.println(bs(3, drinks));
//        System.out.println(bs(5, drinks));

    }
}
