import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class lc112 {

    //
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }

        return false;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum);
    }

    boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) return true;

        return dfs(root.left, sum) || dfs(root.right, sum);
    }

    // 遍历所有路径，查看是否存在
    // 很慢
//    List<Integer> path = new ArrayList<>();
//    int res = 0;
//    boolean flag = false;
//    public boolean hasPathSum(TreeNode root, int sum) {
//        res = sum;
//        dfs(root);
//        return flag;
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) return ;
//        path.add(root.val);
//
//        if (root.left == null && root.right == null) {
//             int sum = path.stream().mapToInt(x -> x).sum();
//            if (sum == res) {
//                flag = true;
//                return ;
//            }
//        }
//        if (root.left != null) dfs(root.left);
//        if (root.right != null)  dfs(root.right);
//        path.remove(path.size() - 1);
//    }

}
