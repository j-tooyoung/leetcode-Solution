import java.util.Arrays;

/**
 * ClassName: lc215
 * Package: PACKAGE_NAME
 * Description:
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * 题解
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 *
 * @date: 2020/4/8 23:08
 * @author: tooyoung
 */

public class lc215 {

    // 暴力排序
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    // patition 快排
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int lo = 0, hi = len - 1;
        while (true) {
            int pivot = partition(nums, lo, hi);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                lo = pivot + 1;
            } else {
                hi = pivot - 1;
            }
        }
    }

    /**
     *  在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     *      * 在遍历过程中保持循环不变量的语义
     *      * 1、[left + 1, j] < nums[left]
     *      * 2、(j, i] >= nums[left]
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo;
        for (int j = lo + 1; j <= hi; j++) {
            if (nums[j] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                i++;
                swap(nums, i, j);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, i] < pivot，并且 (i, j] >= pivot
        swap(nums, i, lo);
        // 交换以后 [left, i - 1] < pivot, nums[i] = pivot, [i + 1, right] >= pivot
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    // 小顶堆
    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    public static void main(String[] args) {

    }
}
