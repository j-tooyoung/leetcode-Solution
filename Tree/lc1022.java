import java.util.ArrayList;
import java.util.List;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class lc1022 {

    int res = 0;
    int mod = 1000000007;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
            }
            res = res % mod + Integer.valueOf(sb.toString(), 2) % mod;
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

    }

}
