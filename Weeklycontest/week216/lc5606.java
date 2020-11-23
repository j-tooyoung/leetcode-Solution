package week216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname lc5668
 * @Description
 * 5606. 具有给定数值的最小字符串
 * https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value/
 *
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5606 {

    // 贪心
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int i;
        for ( i = 0; i < n; i++) {
            if (k < 26 * (n - i - 1) + 1) {
                k -= 1;
                sb.append((char) ('a'));
            } else {
                k -= (n - i - 1) * 26;
                sb.append((char) ('a' + k - 1));
                i++;
                break;
            }
        }
        while (i++ < n) {
            sb.append('z');
        }
        return sb.toString();

    }

    // dfs 暴力超时
    List<String> list;

    // dfs 暴力超时
    public String getSmallestString1(int n, int k) {
        list = new ArrayList<>();
        dfs(0, n, k, new LinkedList<Character>());
        // Collections.sort(list);
        return list.get(0);

    }

    private void dfs(int start,int n, int k, LinkedList<Character> sb) {
        if (start > n || k < 0) {
            return;
        }
        if (start == n) {
            if (k == 0) {
                StringBuilder sb1 = new StringBuilder();
                sb.forEach(val -> sb1.append(val));
                list.add(sb1.toString());
                return;
            }
        }
        for (int i = 1; i <= 26; i++) {
            sb.addLast((char) (i - 1 + 'a'));
            k -= i;
            dfs(start + 1, n, k, sb);
            k += i;
            sb.removeLast();
        }
    }
}
