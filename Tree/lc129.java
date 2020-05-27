import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 */
public class lc129 {

    int res = 0;
    List<String> path = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        //自顶向下dfs遍历
        // 叶子节点
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            res += Integer.parseInt(sb.toString());
//            return; 直接返回会错误
        }

        dfs(root.left);
        dfs(root.right);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("40"));
        System.out.println(Integer.parseInt("40"));
    }

}
