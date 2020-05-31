/**
 * ClassName: lc84
 * Package: PACKAGE_NAME
 * Description:
 * 84. 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @date: 2020/4/8 23:11
 * @author: tooyoung
 */

public class lc84 {

    // 暴力法

    /**
     * 左边看一下，看最多能向左延伸多长，找到大于等于当前柱形高度的最左边元素的下标；
     *
     * 右边看一下，看最多能向右延伸多长；找到大于等于当前柱形高度的最右边元素的下标。
     *
     * 对于每一个位置，我们都这样操作，得到一个矩形面积，求出它们的最大值。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int curHeights = heights[i];
            int l = i, h = i;
            while (l >= 0 && heights[l] >= curHeights) {
                l--;
            }
            while (h < len && heights[h] >= curHeights) {
                h++;
            }
            res = Math.max(res, curHeights * (h - l - 1));
        }
        return res;
    }

    // 单调栈
    public static int largestRectangleArea1(int[] heights) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int[] nums1 = {2};
        System.out.println(largestRectangleArea(nums1));

    }
}
