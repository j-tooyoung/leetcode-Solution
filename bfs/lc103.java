import java.util.*;

/**
 * ClassName: lc103
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:42
 * @author: tooyoung
 */

public class lc103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
//        List<Integer> path;
        LinkedList<Integer> path;
        while (!q.isEmpty()) {
            int size = q.size();
//            path = new ArrayList<>();
            path = new LinkedList<>();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (flag) {
                    path.addLast(node.val);
                }else {
                    //应使用双端队列
//                    path.add(0, node.val);
                    path.addFirst(node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            flag = !flag;
            res.add(path);
        }
        return res;
    }


    // dfs
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if (level %  2 ==0) res.get(level).add(root.val);
        else res.get(level).add(0, root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }


    public static void main(String[] args) {

    }
}
