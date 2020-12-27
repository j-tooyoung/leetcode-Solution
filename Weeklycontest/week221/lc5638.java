package week221;

import java.util.*;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5638 {

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] -o2[1];
            }
        });
        int res = 0;
        int len = apples.length;
        for (int i = 0; i < 40002; i++) {
            if (i < len && apples[i] > 0) {
                pq.add(new int[]{apples[i], i + days[i]});
            }

            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] num = pq.poll();
                res++;
                if (--num[0] > 0) {
                    pq.add(num);
                }
            }
        }


        return res;
    }

    // fixme
    public int eatenApples1(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] -o2[1];
            }
        });
        int res = 0;

        for (int i = 0; i < apples.length; i++) {
            if (apples[i] > 0) {
                pq.add(new int[]{apples[i], i + days[i]});
            }
            while (!pq.isEmpty()) {
                int[] num = pq.poll();
                System.out.println(num[0] + " " + num[1]);

                if (num[1] > i && num[0] > 0) {
                    num[0]--;
                    res++;
                    pq.add(num);
                    break;
                }
            }
        }
        int day = apples.length;
        while (!pq.isEmpty()) {
            int[] num = pq.poll();
            if (num[1] > day && num[0] > 0) {
                int diff = Math.min(num[1] - day, num[0]);
                day += diff;
                res += diff;

            }
        }

        return res;
    }

//   [0,19,19,19,11,14,33,0,28,7,0,28,7,0,21,16,0,22,0,13,8,0,19,0,0,2,26,2,22,0,8,0,0,27,19,16,24,0,20,26,20,7,0,0,29,0,0,16,19,0,0,0,29,30,17,0,23,0,0,26,24,13,3,0,21,0,18,0]
//           [0,5,1,16,7,10,54,0,40,2,0,23,4,0,20,18,0,40,0,22,8,0,35,0,0,3,24,1,8,0,10,0,0,2,38,8,4,0,36,33,14,9,0,0,56,0,0,21,27,0,0,0,14,20,18,0,42,0,0,44,3,8,3,0,10,0,27,0]

}
