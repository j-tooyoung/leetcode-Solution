import java.util.Stack;

/**
 * ClassName: lc112
 * Package: PACKAGE_NAME
 * Description:
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @date: 2020/4/8 22:54
 * @author: tooyoung
 */
//
//public class lc112 {
//
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null ) return false;
//        if (root.left == null && root.right == null) {
//            return sum - root.val == 0;
//        }
//        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
//
//    }
//
//    private boolean helper(TreeNode root, int sum) {
//        sum -= root.val;
//        if (root.left == null && root.right == null && sum == 0) {
//            return true;
//        }
//        if (root.left != null){
//            helper(root.left, sum);
//        }
//        if (root.right != null) {
//            helper(root.right, sum);
//        }
//        return false;
//    }
//
//
//    // dfs 迭代 前序遍历
//    public boolean hasPathSum1(TreeNode root, int sum) {
//        if (root == null ) return false;
//        Stack<TreeNode> st = new Stack<>();
//        Stack<Integer> valSum = new Stack<>();
//        st.push(root);
//        valSum.push(sum - root.val);
//        while (!st.isEmpty()) {
//            TreeNode node = st.pop();
//            int tmpVal = valSum.pop();
//            if (node.left == null && node.right == null && tmpVal == 0) {
//                return true;
//            }
//            // 有问题
////            if (node.left == null && node.right == null) {
////                return tmpVal == 0;
////            }
//            if (node.left == null && node.right == null) {
//                if(tmpVal == 0) return true;
//            }
//            if (node.right != null) {
//                st.push(node.right);
//                valSum.push(tmpVal - node.right.val);
//            }
//            if (node.left != null) {
//                st.push(node.left);
//                valSum.push(tmpVal - node.left.val);
//            }
//        }
//        return false;
//    }
//}
