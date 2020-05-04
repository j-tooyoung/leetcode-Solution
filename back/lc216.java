import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc216
 * Package: PACKAGE_NAME
 * Description:
 * 组合总和iii
 *
 * @date: 2020/4/8 22:32
 * @author: tooyoung
 */

public class lc216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        //
        if (k > n) return res;
        helper(k, n, res, new ArrayList<>(),1,0);
        return res;
    }

    private void helper(int k, int n, List<List<Integer>> res, List<Integer> path, int start, int curSum) {
        if (path.size() > k || curSum > n) return;
        if (path.size() == k) {
            if (curSum == n) res.add(new ArrayList<>(path));
        } else {
            // start 避免搜索之前的数字
            for (int i = start; i <= 9; i++) {
                path.add(i);
                helper(k, n, res, path, i + 1, curSum + i);     // start 从下一个数字开始搜起
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        lc216 lc216 = new lc216();
        System.out.println(lc216.combinationSum3(3, 7).toString());
        System.out.println(lc216.combinationSum3(3, 9).toString());
    }


}
