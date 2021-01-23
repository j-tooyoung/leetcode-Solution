package week171;

import BST.TreeNode;

import java.util.*;

/**
 * @Classname lc1315
 * @Description
 * @Date 2021/1/23 14:23
 * @Created by j-tooyoung
 */
public class lc1315 {

    // bfs
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.add(root);
//        List<TreeNode> list = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode dummpy = new TreeNode(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int val = map.getOrDefault(map.getOrDefault(node, dummpy), dummpy).val;
                if (val % 2 == 0 && val != 0) {
                    sum += node.val;
                }
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    q.add(node.right);

                }
            }
        }
        return sum;
    }

    // dfs todo
    public int sumEvenGrandparent1(TreeNode root) {
        return 0;
    }

}
