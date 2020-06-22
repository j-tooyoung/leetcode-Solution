import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class lc515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
//        res.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            //每层的最大值
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
//            for (int i = 0; i < q.size(); i++) { 入队时，会改变q的大小
                TreeNode tmp = q.poll();
                maxVal = Math.max(maxVal, tmp.val);
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            res.add(maxVal);
        }
        return res;
    }

    // dfs
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
//        res.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            //每层的最大值
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
//            for (int i = 0; i < q.size(); i++) { 入队时，会改变q的大小
                TreeNode tmp = q.poll();
                maxVal = Math.max(maxVal, tmp.val);
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            res.add(maxVal);
        }
        return res;
    }

}
