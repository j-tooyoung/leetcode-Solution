import java.util.HashMap;
import java.util.Map;

/**
 *  653. 两数之和 IV - 输入 BST
 *  https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 */
public class lc653 {

    Map<Integer, Integer> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) return false;
        if (map.containsKey(k - root.val)) {
            return true;
        }
        map.put(root.val, 1);

        return dfs(root.left, k) || dfs(root.right, k);

    }

    public static void main(String[] args) {

    }

}
