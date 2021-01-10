package Dweek22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname lc1387
 * @Description
 * @Date 2021/1/10 20:57
 * @Created by j-tooyoung
 */
public class lc1387 {

    public int getKth(int lo, int hi, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            int cnt = 0;
            int cur = i;
            while (cur != 1) {
                if (cur % 2 == 0) {
                    cur /= 2;
                } else {
                    cur = cur * 3 + 1;
                }
                cnt++;
            }
            list.add(new int[]{i, cnt});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        return list.get(k - 1)[0];
    }

}
