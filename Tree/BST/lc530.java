package BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class lc530 {

    // 中序遍历
    int minVal = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference1(TreeNode root) {
        dfs(root);
        return minVal;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        System.out.println(root.val);
        if(pre != null) minVal = Math.min(minVal, Math.abs(root.val - pre.val));
        pre = root;
        dfs(root.right);
    }

    // 暴力dfs,sort
    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs1(root);
        Collections.sort(res);
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            val = Math.min(val, res.get(i + 1) - res.get(i));
        }
        return val;
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
