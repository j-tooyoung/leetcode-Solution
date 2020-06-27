import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: lc93
 * Package: PACKAGE_NAME
 * Description:
 * 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/*
 * @date: 2020/4/8 22:30
 * @author: tooyoung
 */

public class lc93 {


    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len > 12 || len < 4) return res;
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0,4, path, res);
        return res;
    }

    private static void dfs(String s, int len, int start, int residue, Deque<String> path, List<String> res) {
        if (start == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;

        }
        for (int i = start; i < start + 3; i++) {
            if (i >= len) {
                break;
            }
            // 字符串长度不够
            if (residue * 3 < len - i) {
                continue;
            }
            // 字符串合法
            if (judgeIpSegment(s, start, i)) {
                String currIpSegment = s.substring(start, i + 1);
                path.addLast(currIpSegment);
                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private static boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s).toString());
        String s1 = "";
    }
}
