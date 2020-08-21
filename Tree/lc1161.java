import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class lc1161 {

    // dfs
    public int maxLevelSum(TreeNode root) {
        return 0;
    }

    // bfs
    public int maxLevelSum1(TreeNode root) {
        if (root == null) return 0;
        int minLevel = 0;
        int sum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode tmp = new TreeNode(-1);
        int curLevel = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;
            for (int i = 0; i < size; i++) {
                tmp = q.poll();
                curSum += tmp.val;
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            if (curSum > sum) {
                sum = curSum;
                minLevel = curLevel;
            }
            curLevel++;
        }
        return minLevel;
    }

}
