package week230;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Classname lc5627
 * @Description
 * @Date 2020/12/13 10:37
 * @Created by j-tooyoung
 */
public class lc5692 {

    public double[] getCollisionTimes(int[][] cars) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1);
        list.add(0);
        int t = 0;
        for (int i = 1; i < n; i++) {
            while (!list.isEmpty() && cars[list.getLast()][1] > cars[i][1]) {
                ans[list.getLast()] = (-cars[i][0] + cars[list.getLast()][0]) / (cars[i][1] - cars[list.getLast()][1]);
                list.pollLast();
            }
            list.add(i);
        }

        return ans;
    }


}
