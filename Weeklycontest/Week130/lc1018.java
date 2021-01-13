package Week130;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc1018
 * @Description
 * @Date 2021/1/13 10:37
 * @Created by j-tooyoung
 */
public class lc1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans * 2 + A[i];
            if (ans % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
            ans %= 5;
        }
        return res;
    }
}
