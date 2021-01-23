package week146;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc1128
 * @Description
 * @Date 2021/1/22 10:35
 * @Created by j-tooyoung
 */
public class lc1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
//        int res = 0;
//        for (int i = 0; i < dominoes.length; i++) {
//            int a = dominoes[i][0];
//            int b = dominoes[i][1];
//            for (int j = i + 1; j < dominoes.length; j++) {
//                int[] cnt = new int[10];
//                cnt[a]++;
//                cnt[b]++;
//                cnt[dominoes[j][0]]--;
//                cnt[dominoes[j][1]]--;
//                if (cnt[a] == 0 && cnt[b] == 0) {
//                    res++;
//                }
//            }
//        }
//        return res;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                int tmp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = tmp;
            }
        }
        Arrays.sort(dominoes,(a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        // for (int[] dominoe : dominoes) {
        //     Arrays.stream(dominoe).forEach(value -> System.out.print(value + " "));
        //     System.out.println();
        // }
        int res = 0;
        int len = dominoes.length;
        for (int i = 0; i < dominoes.length; ) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            int j = i +1;
            while (j < len && a == dominoes[j][0] && b == dominoes[j][1]) {
                j++;
            }
            if (j > i + 1) {
                res += (j - i)*(j-i-1)/2;
            }
            i = j;
        }
        return res;
    }
}
