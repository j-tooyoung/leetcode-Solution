import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: lc106
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:53
 * @author: tooyoung
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 */

public class lc106 {

   static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    static TreeNode buildTree(int[] inorder, int Inst, int InEnd, int[] postorder, int posSt, int posEnd) {
        if (Inst > InEnd) return null;

        int len = inorder.length;
        int idx = map.get(postorder[posEnd]);
        TreeNode root = new TreeNode(postorder[posEnd]);
//
//        while (idx <= InEnd && inorder[idx] != postorder[posEnd]) {
//            idx += 1;
//        }

        if (idx > InEnd) return null;
        root.left = buildTree(inorder, Inst, idx - 1, postorder, posSt, posSt + idx - Inst - 1);    //左节点个数为 idx - Inst
        root.right = buildTree(inorder, idx + 1, InEnd, postorder, posSt + idx - Inst, posEnd - 1);
        return root;
    }

    public static void main(String[] args) {

        int[] t1 = {9, 3, 15, 20, 7};
        int[] t2 = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(t1, t2);
        TreeOperation.show(treeNode);
    }
}
