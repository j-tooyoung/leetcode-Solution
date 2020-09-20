package Dweek35;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc5505
 * @Description TODO
 * @Date 2020/9/19 22:48
 * @Created by xp123
 * 5505. 所有排列中的最大和
 */
public class lc5505 {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        long res = 0;
        long mod = 1000_000_007;
        Arrays.sort(requests, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t1[0] - (t2[1] - t2[0]);
            }
        });
        int idx = nums.length - 1;
        for (int i = 0; i < requests.length; i++) {
            int len = requests[i][1] - requests[i][0];

        }
        return (int) (res % mod);
    }
}
