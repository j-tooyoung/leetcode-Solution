import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 *
 */
public class lc1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        int total = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            total = total * 2 + A[i];
            boolean flag = (total % 5 == 0) ? true : false;
            // 避免溢出
            total %= 5;
            res.add(flag);
        }
        return res;
    }

}
