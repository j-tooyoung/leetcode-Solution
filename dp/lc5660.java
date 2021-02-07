import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Classname lc5660
 * @Description
 * @Date 2021/2/6 23:39
 * @Created by j-tooyoung
 */
public class lc5660 {
    public int maxValue(int[][] events, int k) {
        if (events.length == 1) {
            return events[0][2];
        }
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
// Arrays.stream(events).forEach(val -> {
//             System.out.print(val[0] + " " + val[1] + " " + val[2]);
//             System.out.println();
//         });
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        TreeMap<int[], Integer> map = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            dp[0][i] = events[0][2];
        }
        map.put(new int[]{events[0][0], events[0][1], events[0][2], 0}, 0);

        for (int i = 1; i < n; i++) {
            int[] key = {events[i][0], events[i][0]-1, events[i][2],i};
            int[] idx = map.floorKey(key);
            //
            for (int j = 1; j <= k; j++) {
                dp[i][j] = events[i][2];
                if (j >= 1 && idx != null) {
                    // System.out.println("idx[3] = " + idx[3] + "i = " + i  );
                    // System.out.println("i = " + i +" " + dp[idx[3]][j - 1] + events[i][2]);
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[idx[3]][j - 1] + events[i][2], dp[i - 1][j]));
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                ans = Math.max(ans, dp[i][j]);
            }
            map.put(new int[]{events[i][0], events[i][1], events[i][2], i}, i);

        }
        return ans;
    }
}
