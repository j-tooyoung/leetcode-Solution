import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: lc128
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 23:10
 * @author: tooyoung
 */


// https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/tao-lu-jie-jue-zui-chang-zi-xu-lie-deng-yi-lei-wen/
public class lc128 {

    // 并查集
    public static int longestConsecutive(int[] nums) {
        return 0;
    }

    //动态规划
    public static int longestConsecutive4(int[] nums) {
        return 0;
    }


        // set
    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        int res = 1;
        for (int val : set) {
            // 找到起点
            if (!set.contains(val - 1)) {
                int cur = val;
                int cnt = 1;
                // 找到最右
                while (set.contains(cur + 1)) {
                    cur++;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }

    // 暴力法
//    从小到大排序
//    遍历数组，比较相邻的两项，如果相同，则跳过，继续遍历下一项
//    如果 当前项+1 等于 下一项，说明遇到连续项，count +1
//    否则，说明连续中断，将 count 重置为 1
    public static int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        Arrays.sort(nums);
        int res = 1;
        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) continue;
            if (nums[i + 1] == nums[i] + 1) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int[] arr1 = {0};
        int[] arr2 = {1, 2, 0, 1};
        System.out.println(longestConsecutive(arr));
        System.out.println(longestConsecutive(arr1));
        System.out.println(longestConsecutive(arr2));
    }

}
