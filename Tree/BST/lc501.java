package BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class lc501 {

    //
    List<Integer> res = new ArrayList<>();
    private int preval = 0, curCnt = 0, maxCnt = 0;
    public int[] findMode(TreeNode root) {

        helper(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (preval == root.val) {
            curCnt++;
        } else {
            preval = root.val;
            curCnt = 1;
        }
        //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
        if (curCnt == maxCnt) {
            res.add(root.val);
        } else if (curCnt > maxCnt) {
            //清除数据
            res.clear();
            res.add(root.val);
            maxCnt = curCnt;
        }
        helper(root.right);
    }


    // 暴力
//    List<Integer> list = new ArrayList<>();
//    List<Integer> res = new ArrayList<>();
//
//    public int[] findMode1(TreeNode root) {
//        dfs(root);
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int val : list) {
////            if (!map.containsKey(val)) {
////                map.put(val, 0);
////            } else {
////                int num = map.get(val);
////                map.put(val, num + 1);
////            }
////            map.put(val, map.getOrDefault(map.get(val), 0) + 1); 错误
//            map.put(val, map.getOrDefault(val, 0) + 1);
//        }
//        int freq = 0;
//        for (int val : map.keySet()) {
//            freq = Math.max(freq, map.get(val));
//            System.out.println(freq);
//        }
//        for (int val : map.keySet()) {
//            if (freq == map.get(val)) {
//                res.add(val);
//            }
//        }
//        //
////        int[] nums = new int[res.size()];
////        for (int i = 0; i < res.size(); i++) {
////            nums[i] = res.get(i);
////        }
////        return nums;
//// list转换为数组，使用流
//        return list.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) return;
//        dfs(root.left);
//        list.add(root.val);
//        dfs(root.right);
//    }

}
