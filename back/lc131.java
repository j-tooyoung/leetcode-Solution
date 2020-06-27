import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: lc131
 * Package: PACKAGE_NAME
 * Description:
 * 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
 * @date: 2020/4/8 22:31
 * @author: tooyoung
 */

public class lc131 {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s ==null || s.length() < 1) return res;
        int len = s.length();
        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0, len, path, res);
        return res;
    }

    private static void dfs(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        // 结束条件
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (i >= len) return;
            if (isVaild(s, start, i)) {
                // 放到内层更快
                String cur = s.substring(start, i + 1);
                path.addLast(cur);
                dfs(s, i + 1, len, path, res);
                path.removeLast();
            }
        }
    }

    private static boolean isVaild(String s, int i, int j) {
        if (i > j) return false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s).toString());

    }
}
