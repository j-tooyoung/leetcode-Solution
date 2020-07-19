import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: lc120
 * Package: PACKAGE_NAME
 * Description:
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 *
 * @date: 2020/4/8 22:57
 * @author: tooyoung
 */

public class lc120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size(), col = triangle.get(row - 1).size();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = row - 1; i >= 0; i--) {
            //优化，每次内层循环均计算了size()，浪费时间
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle.get(i).get(j);
            }
        }
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][0];
    }



    // 空间优化dp
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size(), col = triangle.get(row - 1).size();
        int[] dp = new int[col + 1];
        for (int i = row - 1; i >= 0; i--) {
            int size = triangle.get(i).size();
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j + 1], dp[j]) + list.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

    }

}
