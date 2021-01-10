package Dweek16;

/**
 * @Classname lc1299
 * @Description
 * @Date 2021/1/10 20:36
 * @Created by j-tooyoung
 */
public class lc1299 {

    public int[] replaceElements(int[] arr) {
        int val = -1;
        int[] res = new int[arr.length];
        int len = arr.length;
        res[len - 1] = val;
        for (int i = len - 2; i >= 0; i--) {
            val = Math.max(val, arr[i + 1]);
            res[i] = val;
        }
        return res;
    }
}
