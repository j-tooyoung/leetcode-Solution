import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class lc04_03 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[]{};
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree);
        List<ListNode> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            ListNode tmp = new ListNode(-1);
            ListNode head = tmp;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                head.next = new ListNode(node.val);
                head = head.next;
            }
            list.add(tmp.next);
        }
//        ListNode[] res = new ListNode[list.size()];
//        return list.toArray(res);
        return list.toArray(new ListNode[0]);
    }
}
