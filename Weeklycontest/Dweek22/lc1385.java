package Dweek22;

import java.util.Arrays;

/**
 * @Classname lc1385
 * @Description
 * @Date 2021/1/10 20:57
 * @Created by j-tooyoung
 */
public class lc1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
//        Arrays.sort(arr2);
        int minVal = Arrays.stream(arr2).min().getAsInt();
        int maxVal = Arrays.stream(arr2).max().getAsInt();
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d || Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans++;
            }
        }
        return ans;
    }
}
