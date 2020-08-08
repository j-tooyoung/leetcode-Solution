import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class lc872 {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            return root1.val == root2.val;
        }
        dfs(root1, list1);
        dfs(root2, list2);
//        if (list1.size() != list2.size()) return false;
//        for (int i = 0; i < list1.size(); i++) {
//            if (list1.get(i) != list2.get(i)) {
//                return false;
//            }
//        }
//        return true;
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root==null) return;
        dfs(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(root.right, list);
    }

    public static void main(String[] args) {

    }


}
