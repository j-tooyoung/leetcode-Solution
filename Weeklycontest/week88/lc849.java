package week88;

/**
 * @Classname lc849
 * @Description
 * @Date 2021/1/15 12:42
 * @Created by j-tooyoung
 */
public class lc849 {


    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int prev = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    res = Math.max(res, i);
                } else {
                    res = Math.max(res, (i - prev) / 2);
                }
                prev = i;
            }
        }
        res = Math.max(res, seats.length - prev - 1);
        return res;
    }

}
