import java.util.Map;
import java.util.Stack;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class lc783 {

    //非递归二叉树中序遍历
    public int minDiffInBST(TreeNode root) {
        int minVal = Integer.MAX_VALUE;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
//        TreeNode pre = null;
//        int pre = Integer.MIN_VALUE;
        int pre = -100;
        while (!st.isEmpty() || cur != null) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            minVal = Math.min(minVal, cur.val - pre);
            pre = cur.val;
            cur = cur.right;
        }
        return minVal;
    }

    public static void main(String[] args) {
        System.out.println(2-Integer.MIN_VALUE);
        System.out.println(2+Integer.MIN_VALUE);
        System.out.println(2 + 100);
        System.out.println(2 - 100);
        System.out.println(Integer.MIN_VALUE);
    }
}
