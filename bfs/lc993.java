import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * ClassName: lc993
 * Package: PACKAGE_NAME
 * Description:
 * 993. 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 *
 * @date: 2020/4/8 22:49
 * @author: tooyoung
 */

public class lc993 {

    Map<Integer, Integer> depth = new HashMap<>();
    Map<Integer, TreeNode> parent = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        if (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y)) {
            return true;
        }
        return false;
    }

    private void dfs(TreeNode root, TreeNode pre) {
        if (root == null) return;
//        depth.put(root.val, pre == null ? 0 : depth.get(pre.val) + 1);
        depth.put(root.val, depth.getOrDefault(pre.val,0) + 1);
        parent.put(root.val, pre);

        dfs(root.left, root);
        dfs(root.right, root);
    }

    public boolean isCousins1(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return true;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, Integer> map = new HashMap<>();
            int idx = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null){
                    map.put(node.val, idx++);
                    q.add(node.left);
                    q.add(node.right);
                } else{
                    map.put(-1, idx++);
                }
            }
            if (map.containsKey(x) && map.containsKey(y)) {
                int idx1 = map.get(x);
                int idx2 = map.get(y);
                if (Math.abs(idx1 - idx2) == 1 && Math.min(idx1, idx2) % 2 == 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }


}
