/**
 * ClassName: lc287
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:41
 * @author: tooyoung
 */

public class lc287 {

    public int findDuplicate(int[] nums) {

        // 找交点
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
//            System.out.println(fast + "," + slow);
            if (fast == slow) break;
        }
        // 找入口点
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
//            System.out.println(fast + "," + slow);
        }
        return slow;
    }

    // 二分
    public int findDuplicate1(int[] nums) {

        int i = 1, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int cnt = 0;
            for (int val : nums) {
                if (val <= mid) cnt++;
            }
            if (cnt > mid ) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        lc287 lc287 = new lc287();
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(lc287.findDuplicate(nums));
    }
}
