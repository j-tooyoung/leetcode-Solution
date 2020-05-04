import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 1389. 按既定顺序创建目标数组
 * https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 */
public class lc1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(index[i], nums[i]);
        }
//        int[] arr = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            arr[i] = res.get(i);
//        }
//        return arr;
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
