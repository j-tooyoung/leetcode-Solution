import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class lc08_06 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        int n = A.size();
        hanoi(n, A, B, C);

    }

    private void hanoi(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 1) {
            c.add(a.remove(a.size() - 1));
            return;
        } else {
            hanoi(n - 1, a, c, b);
            c.add(a.remove(a.size() - 1));
            hanoi(n - 1, b, a, c);
        }
    }
}
