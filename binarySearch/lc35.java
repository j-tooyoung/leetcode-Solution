/**
 * ClassName: lc35
 * Package: PACKAGE_NAME
 * Description:
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @date: 2020/4/8 22:51
 * @author: tooyoung
 */

public class lc35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        // 因为有可能数组的最后一个元素的位置的下一个是我们要找的，故右边界是 len
        int i = 0, j = nums.length;
        // 终止出口，为i >= j
        while (i < j) {
            int mid = (i + j) / 2;
            // 小于 target 的元素一定不是解
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;

//        System.out.println(i + "," + j);
    }

    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid ;        // j = mid - 1不可以， 会出现 j < 0
            }
        }
        // 终止出口，为i >= j
//        System.out.println(i + "," + j);
        return nums[j] < target ? i + 1 : i;    //target大于所有数，插入到
    }

    public int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;     // j = mid;
            }
        }
        // 终止出口，为i >= j
//        System.out.println(i + "," + j);
        return nums[i] < target ? i + 1 : i;    //target大于所有数，插入到
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,3,5,6};
        lc35 lc35 = new lc35();
//        System.out.println(lc35.searchInsert(num1, 5));
//        System.out.println(lc35.searchInsert(num1, 2));
//        System.out.println(lc35.searchInsert(num1, 7));
//        System.out.println(lc35.searchInsert(num1, 0));
        int[] num = new int[]{1, 3};
        System.out.println(lc35.searchInsert(num, 0));

    }
}
