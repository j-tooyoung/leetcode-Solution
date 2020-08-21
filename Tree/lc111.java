import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class lc111 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);
        while (!st.isEmpty()) {
            res++;
            int size = st.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = st.poll();
                // 叶子节点时，即为最小高度
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    st.add(node.left);
                }
                if (node.right != null) {
                    st.add(node.right);
                }
            }
        }
        return res;
    }

    // 特例
    //   1
    // 2
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null) {
            return 1 + minDepth1(root.left);
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth1(root.right);
        }
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
//        if(root == null) return 0;
//        int m1 = minDepth(root.left);
//        int m2 = minDepth(root.right);
//        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
//        //2.如果都不为空，返回较小深度+1
//        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
//
//        作者：reals
//        链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                if (tmp.left == null && tmp.right == null) return ++cnt;
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            ++cnt;
        }
        return cnt;
    }
}
