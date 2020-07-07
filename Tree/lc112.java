import java.util.ArrayList;
import java.util.List;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class lc112 {

    //
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return dfs(root, sum);
    }

    boolean dfs(TreeNode root, int sum){
        if(root== null) return false;
        sum -= root.val;

        if(root.left == null && root.right == null && sum == 0) return true;

        return dfs(root.left, sum) ||  dfs(root.right, sum);
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
