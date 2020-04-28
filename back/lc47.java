import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc47
 * Package: PACKAGE_NAME
 * Description:
 * 全排列II
 * @date: 2020/4/8 22:28
 * @author: tooyoung
 */

public class lc47 {

    public static void main(String[] args) {
        final lc47 lc47 = new lc47();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutation = lc47.permuteUnique(nums);
        //输出
        printArrayList<Integer> pr = new printArrayList<>();
        pr.printArrayList(permutation);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
}
