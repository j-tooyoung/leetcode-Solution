package week146;

/**
 * @Classname lc1131
 * @Description
 * @Date 2021/1/22 10:49
 * @Created by j-tooyoung
 */
public class lc1131 {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans = Math.max(ans, Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j));
            }
        }
        return ans;
    }

}
