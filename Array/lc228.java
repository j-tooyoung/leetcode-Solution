import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc228
 * @Description
 * @Date 2021/1/10 12:21
 * @Created by j-tooyoung
 */
public class lc228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1]+1) {
                j++;
            }
            if (j == i+1) {
                res.add(String.valueOf(nums[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                sb.append("->");
                sb.append(nums[j-1]);
                res.add(sb.toString());
            }
            i = j;

        }
        return res;
    }
}
