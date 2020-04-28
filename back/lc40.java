import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: lc40
 * Package: PACKAGE_NAME
 * Description:
 * 组合总和II
 *
 * @date: 2020/4/8 22:27
 * @author: tooyoung
 */

public class lc40 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        final lc40 lc40 = new lc40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(candidates);
        List<List<Integer>> sol = lc40.combinationSum2(candidates, 8);
        printArrayList(sol);

//        int[] candidates1 = {2, 5, 2, 1, 2};
//        printArrayList(lc40.combinationSum2(candidates1, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, res, path, 0);
        return res;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 需剪支，有重复答案
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                path.add(candidates[i]);
                helper(candidates, target - candidates[i], res, path, i + 1);
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
