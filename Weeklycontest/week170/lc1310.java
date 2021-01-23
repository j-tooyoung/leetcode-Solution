package week170;

/**
 * @Classname lc1310
 * @Description
 * @Date 2021/1/23 14:09
 * @Created by j-tooyoung
 */
public class lc1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] pre = new int[len + 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = pre[queries[i][0]] ^ pre[queries[i][1] + 1];
        }
        return res;
    }
}
