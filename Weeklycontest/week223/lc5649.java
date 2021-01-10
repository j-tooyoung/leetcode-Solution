package week223;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5649 {

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i <= encoded.length; i++) {
            res[i] = encoded[i-1] ^ res[i-1];
        }
        return res;
    }

}


