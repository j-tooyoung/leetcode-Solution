import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: lc199
 * Package: PACKAGE_NAME
 * Description:
 * 199. 二叉树的右视图
 * @date: 2020/4/8 22:47
 * @author: tooyoung
 */

public class lc199 {


    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }

    //dfs
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
         // ?
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        dfs(root.right, res,depth + 1);
        dfs(root.left, res, depth + 1);

    }

    public static void main(String[] args) {

    }
}
