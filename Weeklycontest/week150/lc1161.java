package week150;

import BST.TreeNode;

import java.util.*;

/**
 * @Classname lc1161
 * @Description
 * @Date 2021/1/12 18:15
 * @Created by j-tooyoung
 */
public class lc1161 {

    public int maxLevelSum(TreeNode root) {
        List<int[]> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            idx++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level.add(new int[]{idx, sum});
        }
        level.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        return level.get(0)[0];
    }

}
