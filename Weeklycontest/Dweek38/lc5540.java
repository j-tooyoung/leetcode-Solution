package Dweek38;

import java.util.*;

/**
 * @Classname lc5545
 * @Description
 * @Date 2020/10/18 20:13
 * @Created by j-tooyoung
 */
public class lc5540 {

    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list.add(points[i][0]);
        }
        Collections.sort(list);
        int res = list.get(1) - list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = Math.max(res, list.get(i) - list.get(i - 1));
        }
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] p1, int[] p2) {
//                return p1[];
//            }
//        });
        return res;
    }

    public static void main(String[] args) {

    }

}
