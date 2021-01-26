package Dweek44;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5645 {

    public int largestAltitude(int[] gain) {
        int pre = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < gain.length; i++) {
            res = Math.max(res, pre);
            pre += gain[i];
        }
        res = Math.max(res, pre);
        return res;
    }

}


