import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: lc102
 * Package: PACKAGE_NAME
 * Description:
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @date: 2020/4/8 22:42
 * @author: tooyoung
 */
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
public class lc102 {

    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                path.add(node.val);
            }
            res.add(path);
        }
        return res;
    }

    //dfs 递归
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 1);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int idx) {
        if (root == null) return;
//        每次递归的时候都需要带一个 index(表示当前的层数)，也就对应那个田字格子中的第几行，如果当前行对应的 list 不存在，就加入一个空 list 进去。
        if (idx > res.size()) {
            res.add(new ArrayList<>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99

        if (root != null) res.get(idx - 1).add(root.val);
        dfs(root.left, res, idx + 1);
        dfs(root.right, res, idx + 1);
    }

    public static void main(String[] args) {

    }
}
