import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc39
 * Package: PACKAGE_NAME
 * Description:
 * 组合总和
 *  https://leetcode-cn.com/problems/combination-sum/solution/fei-chang-xiang-xi-de-di-gui-hui-su-tao-lu-by-re-2/
 * @date: 2020/4/8 22:27
 * @author: tooyoung
 */

public class lc39 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        final lc39 lc39 = new lc39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> sol = lc39.combinationSum(candidates, 7);
        printArrayList(sol);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        helper(candidates, res, path, target,0);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> path, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                helper(candidates, res, path, target - candidates[i], i);
//                helper(candidates, res, path, target - candidates[i], start);    //start错误
                path.remove(path.size() - 1);
            }
        }
    }


    public static void printArrayList(List<List<Integer>> res) {
        System.out.println("[");
        for (List<Integer> ls : res) {
            System.out.print("  [");
            for (int i = 0; i < ls.size() - 1; i++) {
                System.out.print(ls.get(i) + ",");
            }
            System.out.print(ls.get(ls.size() - 1) + "]\n");
        }
        System.out.println("]");
    }
}
