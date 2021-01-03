package Week222;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5641 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize < 0) {
                break;
            }
            if (truckSize >= boxTypes[i][0]) {
                res += boxTypes[i][0] * boxTypes[i][1];
            } else {
                res += truckSize * boxTypes[i][1];
            }
            truckSize -= boxTypes[i][0];

        }
        return res;
    }


}


