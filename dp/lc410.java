/**
 * 410. 分割数组的最大值
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 *
 *
 * 计算数组和最大值不大于mid对应的子数组个数 cnt(这个是关键！)
 * 如果 cnt>m，说明划分的子数组多了，即我们找到的 mid 偏小，故 l=mid+1l=mid+1；
 * 否则，说明划分的子数组少了，即 mid 偏大(或者正好就是目标值)，故 h=midh=mid。
 *
 * 作者：coder233
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-coder233-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class lc410 {

    public static int splitArray(int[] nums, int m) {
        // 必须将左边l 设置为数组的最大值，否则后续区间计数无限循环
        long l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            r += nums[i];
            l = Math.max(l, nums[i]);
        }
        if (m == 1) return (int) r;

        while (l < r) {
            long mid =  (l + r ) >> 1;

            if (split(nums, mid) > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) l;
    }

    // 划分的个数，区间最大和为mid的个数
    private static int split(int[] nums, long mid) {
        long sum = 0;
        int start = 0;
        int cnt = 0;
        int len = nums.length;
        while (start < len) {
            // 区间最大和不超过mid
            while (start < len && sum + nums[start] <= mid) {
                sum += nums[start];
                start++;
            }
            cnt++;
            sum = 0;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int[] arr1 = {1,2147483646};
        int[] arr2 = {1,2147483646};
        System.out.println(splitArray(arr, 2));
//        System.out.println(splitArray(arr1, 1));
//        System.out.println(splitArray(arr1, 2));
//        System.out.println(splitArray(arr2, 2));
    }
}
