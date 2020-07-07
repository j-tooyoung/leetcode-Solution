import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class lc41 {

    //暴力
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


    public static int firstMissingPositive1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //将数放到正确的位置
            // 有重复数循环，
            while (nums[i] - 1 != i && nums[i] > 0 && nums[i] - 1 < len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
//                int tmp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i;
            }
        }
        return len + 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
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
