import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kthToLast {
    public int kthToLast(ListNode head, int k) {
        return 0;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.add(root);
        TreeNode tmp;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                tmp = q.poll();
                path.add(tmp.val);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            res.add(path);
        }
        return res;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }
}
