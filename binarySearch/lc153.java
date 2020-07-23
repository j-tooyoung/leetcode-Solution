import java.util.Map;

/**
 * ClassName: lc153
 * Package: PACKAGE_NAME
 * Description:
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @date: 2020/4/8 22:52
 * @author: tooyoung
 */

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lc153 {

    public static int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else if (nums[mid] < nums[j]) {
                j = mid;
            }
            //有问题
//            if (nums[mid] > nums[i]) {
//                i = mid ;
//            } else if (nums[mid] < nums[i]) {
//                j = mid;
//            }
        }
        return nums[i];
    }

    public int findMin1(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for (int val : nums) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int[] nums1 = {3, 4, 5};
        System.out.println(findMin(nums));
//        System.out.println(findMin(nums1));
    }
}
