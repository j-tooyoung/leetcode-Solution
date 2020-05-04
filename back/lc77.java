import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc77
 * Package: PACKAGE_NAME
 * Description:
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 * 题解
 * https://leetcode-cn.com/problems/combinations/solution/hui-su-si-xiang-tuan-mie-pai-lie-zu-he-zi-ji-wen-2/
 * @date: 2020/4/8 22:29
 * @author: tooyoung
 */

public class lc77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        helper(n, k, res, new ArrayList<Integer>(), new boolean[n + 1],1);
//        int[] num = new int[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            num[i] = i;
//        }
//        helper1(num, k, res, new ArrayList<Integer>(), new boolean[n + 1],1);
        return res;
    }

    private void helper(int n, int k, List<List<Integer>> res, ArrayList<Integer> path, boolean[] used,int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        } else {
            // 剪支
            for (int i = start; i <= n - (k - path.size()) + 1 ; i++) {
                // 不需要boolean数组
                // if (!used[i]) {
                // used[i] = true;
                path.add(i);
                helper(n, k, res, path, used,i+1);  // start+1 错误
                // used[i] = false;
                path.remove(path.size() - 1);
                // }
            }
        }
    }


    // meet some problem
    private void helper1(int[] num, int k, List<List<Integer>> res, ArrayList<Integer> path, boolean[] used,int start) {
        if (path.size() == k) {
            System.out.println(path);
            res.add(new ArrayList<>(path));
        } else {
            for (int i = start ; i < num.length; i++) {
                swap(num, i, start);
                path.add(num[i]);
                helper1(num, k, res, path, used, i + 1);
                path.remove(path.size() - 1);
                swap(num, i, start);
            }
        }
    }

    private void swap(int[] num, int i, int start) {
        int tmp = num[i];
        num[i] = num[start];
        num[start] = tmp;
    }

    public static void main(String[] args) {
        lc77 lc77 = new lc77();
        System.out.println(lc77.combine(4, 2).toString());
    }
}
