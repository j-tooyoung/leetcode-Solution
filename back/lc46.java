import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc46
 * Package: PACKAGE_NAME
 * Description:
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @date: 2020/4/8 22:28
 * @author: tooyoung
 */

public class lc46 {

    public static void main(String[] args) {
        final lc46 lc46 = new lc46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutation = lc46.permutation(nums);
        //输出
        printArrayList<Integer> pr = new printArrayList<>();
        pr.printArrayList(permutation);
    }

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
}
