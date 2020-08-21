import java.util.ArrayList;
import java.util.List;

/**
 * 1237. 找出给定方程的正整数解
 * https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/
 */
public class lc1237 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        // 1000改为z 快很多
        for (int i = 1; i <= 1000; i++) {
            int lo = 1, hi = 1000;
            while (lo < hi) {
                int mid = lo + hi >> 1;
                if (customfunction.f(i, mid) < z) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tmp = new ArrayList<>();
            if (customfunction.f(i, hi) == z) {
                tmp.add(i);
                tmp.add(hi);
                res.add(tmp);
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }

}
