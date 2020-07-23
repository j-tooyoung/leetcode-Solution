import java.util.*;
import java.util.stream.Collectors;

/**
 * 442. 数组中重复的数据
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class lc422 {

    //暴力法
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    //暴力法
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] cnt = new int[nums.length + 1];
        for (int val : nums) {
            cnt[val]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cnt[nums[i]] == 2) {
                res.add(nums[i]);
                set.add(nums[i]);
            }
        }
//        return res.stream().distinct().collect(Collectors.toList());
        return set.stream().collect(Collectors.toList());
    }

}
