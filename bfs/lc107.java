import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: lc107
 * Package: PACKAGE_NAME
 * Description:
 * 107. 二叉树的层次遍历 II
 *https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @date: 2020/4/8 22:46
 * @author: tooyoung
 */

public class lc107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            List<Integer> path = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = q.poll();
//                if (node.left != null) q.add(node.left);
//                if (node.right != null) q.add(node.right);
//                path.add(node.val);
//            }
//            res.add(0, path);
//        }
//        return res;
    }

    // dfs
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        dfs(root, res, 1);
        return res;
    }

    /**
     * 如果当前的list 大小，小于目前的层级，需要增加一层，例如：当前遍历到第二层，list的大小还是1
     *
     * 关键在于 result.size() - level，
     * 最下面的层级在list里面的下标肯定是0
     * 那么当前层的下标则是list大小减去当前层（层级从1开始）。（如果从0开始，需要再减1）
     *
     * @param level 层级从1开始
     */
//
//    作者：xmzyjr
//    链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/dfs-shu-de-bian-li-by-xmzyjr/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private void dfs(TreeNode root, LinkedList<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(0,new ArrayList<>());
        }
        res.get(res.size() - level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    public static void main(String[] args) {

    }
}
