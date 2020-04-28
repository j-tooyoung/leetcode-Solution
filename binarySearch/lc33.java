/**
 * ClassName: lc33
 * Package: PACKAGE_NAME
 * Description:
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @date: 2020/4/8 22:51
 * @author: tooyoung
 */

public class lc33 {


    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i < j) {
            int mid = i + j >> 1;
            // [i,mid]有序
            if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target <= nums[mid]) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
                // [mid,j]有序
            } else  {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
        }
        return nums[i] == target ? i : -1;

//        if (nums == null || nums.length < 1) {
//            return -1;
//        }
//        int i = 0, j = nums.length - 1;
//        // 递增序列，直接二分
//        if (nums[i] < nums[j]) {
//            int idx = bs(nums, i, j, target);
//            return nums[idx] == target ? idx : -1;
//        } else {
////            while (i < j) {
//            int mid = i + j >>> 1;
//            // mid 在递增的前半部分
//            if (nums[mid] >= nums[i]) {
//                // target 在递增的前半部分
//                if (target >= nums[i]) {
//                    if (target > nums[mid]) {
//                        i = mid + 1;
//                    } else {
//                        j = mid;
//                        int idx = bs(nums, i, j, target);
//                        return nums[idx] == target ? idx : -1;
//                    }
//                } else {
//                    // target 在递增的后半部分
//                    i = mid + 1;
//                }
//            } else {
//                // mid 在递增的后半部分
//                // target 在递增的后半部分
//                if (target <= nums[j]) {
//                    if (target > nums[mid]) {
//                        i = mid + 1;
//                        int idx = bs(nums, i, j, target);
//                        return nums[idx] == target ? idx : -1;
//                    } else {
//                        j = mid;
//                    }
//                } else {
//                    // target 在递增的前半部分
//                    j = mid;
//                }
//            }
//        }
////        }
//        return nums[j] == target ? j : -1;
    }

    public int bs(int[] nums, int i, int j, int target) {
        while (i < j) {
            int mid = i + j >>> 1;
            if (target <= nums[mid]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        lc33 lc33 = new lc33();
        System.out.println(2 << 1);
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        int[] nums1 = new int[]{5,1,3};
//        System.out.println(lc33.search(nums1, 1));
    }
}
