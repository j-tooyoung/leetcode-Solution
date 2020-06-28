import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class lc41 {

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            if (nums[i] == res) {
                res++;
            } else if (nums[i] > res){
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int[] nums1 = {3, 4, -1, 1};
        int[] nums2 = {0,2,2,1,1};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositive(nums2));
    }
}
