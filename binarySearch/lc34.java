/**
 * ClassName: lc34
 * Package: PACKAGE_NAME
 * Description:
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @date: 2020/4/8 22:51
 * @author: tooyoung
 */

public class lc34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;
        int left = 0, right = nums.length - 1;

        //最后一个等于target的位置
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        res[1] = (nums[left] == target) ? left : -1;
        //第一个等于target的位置
        left = 0; right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        res[0] = (nums[left] == target) ? left : -1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        lc34 lc34 = new lc34();
        int[] res = new int[2];
        res = lc34.searchRange(nums, 8);
        System.out.println(res[0] + "," + res[1]);
    }
}
