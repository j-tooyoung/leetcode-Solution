package Dweek37;

import java.util.Arrays;

/**
 * @Classname lc5138
 * @Description
 * @Date 2020/10/4 13:55
 * @Created by j-tooyoung
 */
public class lc5122 {

    public double trimMean(int[] arr) {
        double sum = 0;
        int len = arr.length;
        Arrays.sort(arr);
        int start = (int) (len * 0.05);
        int end = (int) (len * 0.95);
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum / (end - start);
    }


}
