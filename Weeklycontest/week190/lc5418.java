package week190;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 5418. 二叉树中的伪回文路径
 * https://leetcode-cn.com/contest/weekly-contest-190/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class lc5418 {

    //    dfs找到所有的路径
//    对于每一个路径判断能否构成回文，我这里的做法是用一个set，如果之前有当前的数字，那么从set中删掉（相当于抵消），否则添加，最后看set的长度，若小于等于1则可以构成回文，等于0代表：所有的数字都抵消则将每一个数字分别放在两边可构成回文；等于1代表：还剩一个数字，将这个数放在中间，其余数字放在两边可构成回文。
    int res = 0;
    List<Integer> path = new ArrayList<>();     // 得初始化path

    public  int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            int[] cnt = new int[10];
            int single = 0;     //未成对数量
            for (int val : path) {
                cnt[val]++;
            }
            for (int val : cnt) {
                if (val % 2 != 0) single++;
            }
            if (single <= 1) res++;
        }

        if (root.left != null) helper(root.left);
        if (root.right != null) helper(root.right);
        path.remove(path.size() - 1);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 打印Tree
     * @param node
     */
    public static void printTree(TreeNode node) {

    }
}




