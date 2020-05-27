import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class lc257 {

    // 法1  https://leetcode-cn.com/problems/binary-tree-paths/solution/marveljian-dan-de-xue-xi-bi-ji-257-by-tyanyonecanc/
    //
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return res;
    }
    //注意传参
    private void dfs(TreeNode root, String path) {
        if (root == null) return;
        path += String.valueOf(root.val);
        // path += "->";
        if (root.right == null && root.left == null) {
            res.add(path);
        }

        if (root.left != null)dfs(root.left, path +"->");
        if (root.right != null) dfs(root.right,path+"->");
    }

    // 法2
//    List<String> path = new ArrayList<>();
//    List<String> res = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        dfs(root);
//        return res;
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) return;
//        path.add(String.valueOf(root.val));
//        if (root.right == null && root.left == null) {
//             String s = String.join("->", path);
//            res.add(s);
////            StringBuilder sb = new StringBuilder();
////            for (int i = 0; i < path.size(); i++) {
////                if (i == path.size() - 1) {
////                    sb.append(path.get(i));
////                    continue;
////                }
////                sb.append(path.get(i)).append("->");
////            }
////            res.add(sb.toString());
//        }
//
//        if (root.left != null)dfs(root.left);
//        if (root.right != null) dfs(root.right);
//        path.remove(path.size() - 1);
//    }
}
