package week209;

import BST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 5532. 奇偶树
 * https://leetcode-cn.com/contest/weekly-contest-209/problems/even-odd-tree/
 */
public class lc5532 {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            if (!check(list, level)) {
                return false;
            }
            level++;
        }
        return true;
    }

    private boolean check(List<Integer> list, int level) {
        //
        if (list.size() == 1) {
            if (level % 2 == 0) {
                return list.get(0) % 2 == 1;
            } else {
                return list.get(0) % 2 == 0;
            }
        }
        if (level % 2 == 0) {

            for (int i = 0; i + 1 < list.size(); i++) {
                if (list.get(i) % 2 == 0 || list.get(i + 1) % 2 == 0 || list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i + 1 < list.size(); i++) {
                if (list.get(i) % 2 == 1 || list.get(i + 1) % 2 == 1 || list.get(i) <= list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }

}
