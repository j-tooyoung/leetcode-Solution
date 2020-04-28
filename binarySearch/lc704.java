/**
 * 704. 二分查找
 *https://leetcode-cn.com/problems/binary-search/
 */
public class lc704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 只有一个元素时
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return  -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 退出时有两个元素时
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {

    }
}
