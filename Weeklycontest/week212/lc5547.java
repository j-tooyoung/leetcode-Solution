package week212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname lc5541
 * @Description
 * @Date 2020/10/18 20:12
 * @Created by j-tooyoung
 */
public class lc5547 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = nums.length;
        List<Boolean> res = new ArrayList<>();
        int m = l.length;
        int[] tmp = new int[510];
        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];
            System.arraycopy(nums, left, tmp, 0, right - left + 1);
            Arrays.sort(tmp, 0, right - left + 1);
            int diff = tmp[1] - tmp[0];
            int lenTmp = right - left + 1;
            boolean flag = true;
            for (int k = 1; k < lenTmp; k++) {
                if (diff != tmp[k] - tmp[k - 1]) {
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }
        return res;

//        boolean[][] dp = new boolean[len][len];
//        for (int i = 0; i < len; i++) {
//            int[] target = new int[len];
//
//            for (int j = i + 1; j < len; j++) {
//                System.arraycopy(nums, i, target, 0, j - i + 1);
//                //    for (int i1 : target) {
//                //     System.out.print(i1 + " ");
//                // }
//                //     System.out.println("------------" + i +" " + j);
//                Arrays.sort(target);
//                int diff = target[1] - target[0];
//                boolean flag = true;
//                for (int k = 1; k < target.length; k++) {
//                    if (diff != target[k] - target[k - 1]) {
//                        flag = false;
//                        break;
//                    }
//                }
//                dp[i][j] = flag;
//            }
//        }
//        List<Boolean> res = new ArrayList<>();
//        for (int i = 0; i < l.length; i++) {
//            res.add(dp[l[i]][r[i]]);
//        }
//        return res;
    }

}
