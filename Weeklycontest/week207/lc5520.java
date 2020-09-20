package week207;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc5520
 * @Description TODO
 * @Date 2020/9/20 10:32
 * @Created by xp123
 * 5520. 拆分字符串使唯一子字符串的数目最大
 * https://leetcode-cn.com/contest/weekly-contest-207/problems/split-a-string-into-the-max-number-of-unique-substrings/
 */
public class lc5520 {

    Set<String> set = new HashSet<String>();
    int ans = 0;

    public int maxUniqueSplit(String s) {
        dfs(s, 0);
        return ans;

    }

    private void dfs(String s, int pos) {
        if (pos == s.length()) {
            ans = Math.max(ans, set.size());
        }
        String tmp = "";
        for (int i = pos; i < s.length(); i++) {
            tmp += s.charAt(i);
            if (!set.contains(tmp)) {
                set.add(tmp);
                dfs(s, i + 1);
                set.remove(tmp);
            }
        }
//         StringBuilder tmp = new StringBuilder();
//        for (int i = pos; i < s.length(); i++) {
//            tmp.append(s.charAt(i));
//            if (!set.contains(tmp.toString())) {
//                set.add(tmp.toString());
//                dfs(s, i + 1);
//                set.remove(tmp.toString());
//            }
//        }
    }
}
