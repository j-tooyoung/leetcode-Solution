import java.util.Arrays;

/**
 * 1051. 高度检查器
 * https://leetcode-cn.com/problems/height-checker/
 */
public class lc1051 {

    public int heightChecker(int[] heights) {
        int ans = 0;
        int[] arr = new int[heights.length];
        System.arraycopy(heights, 0, arr, 0, heights.length);

        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (arr[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
