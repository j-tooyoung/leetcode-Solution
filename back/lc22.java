
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc22
 * Package: PACKAGE_NAME
 * Description:
 * 括号生成
 * @date: 2020/4/8 22:26
 * @author: tooyoung
 */

public class lc22 {

    // 法1：暴力穷举法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(new char[n * 2], res,0);
        return res;
    }

    private void helper(char[] ch,  List<String> res, int pos) {
        if (pos == ch.length) {
            if (isValid(ch)) {
                res.add(new String(ch));
            }
        } else {
            ch[pos] = '(';
            helper(ch, res, pos + 1);
            ch[pos] = ')';
            helper(ch, res, pos + 1);
        }
    }

    private boolean isValid(char[] s) {
        int cnt = 0;
        int idx = 0;
        while (idx < s.length) {
            if (cnt < 0) return false;
            cnt = (s[idx++] == '(') ? ++cnt : --cnt;
//            cnt = (s[idx++] == '(') ? cnt++ : cnt--;     wrong cnt= 0
//            验证
//            int cnt = 0;
//        cnt = true ? cnt++ : cnt--;
//        System.out.println(cnt);
//        cnt = true ? ++cnt : --cnt;
//        System.out.println(cnt);
        }
        return cnt == 0;
    }

    // 法2：回溯法  剪去不可能的分支集合
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
//        helper1(res, "", 0, 0, n);
        helper1(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void helper1(List<String> res, String curStr, int left, int right,int n) {
        if (left == n && right == n) {
            res.add(curStr);
        } else {
            if (left < n) {
                helper1(res, curStr + "(", left + 1, right, n);
            }
            if (left > right) {
                helper1(res,  curStr + ")", left, right + 1,n);
            }
        }
    }

    // 有问题？
    private void helper1(List<String> res, StringBuilder sb, int left, int right,int n) {
        if (left == n && right == n) {
            res.add(new String(sb));
            return;
        } else {
            if (left < n) {
                sb.append("(");
                helper1(res, sb, left + 1, right, n);
                sb.deleteCharAt(sb.length() - 1);
//                helper1(res, sb.append("("), left + 1, right, n); 错误  StringBuilder每次生成新对象，导致回溯出问题sb一直保存原先数据
            }
            if (left > right) {
                sb.append(")");
                helper1(res, sb, left, right + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // 动态规划
//    我们需要枚举与第一个 ( 对应的 ) 的位置 2 * i + 1；
//    递归调用 generate(i) 即可计算 a 的所有可能性；
//    递归调用 generate(n - i - 1) 即可计算 b 的所有可能性；
//    遍历 a 与 b 的所有可能性并拼接，即可得到所有长度为 2 * n 的括号序列。
    public List<String> generateParenthesis2(int n) {
        return generate(n);
    }

    ArrayList[] cache = new ArrayList[100];
    private List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) res.add("");
        else {
            for (int i = 0; i < n; i++) {
                for (String left : generate(i)) {
                    for (String right : generate(n - i - 1)) {
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = res;
        return res;
    }


    public static void main(String[] args) {
        lc22 a = new lc22();
        List<String> res = a.generateParenthesis(3);        //暴力
        List<String> res1 = a.generateParenthesis1(3);      //回溯
        List<String> res2 = a.generateParenthesis2(3);      //动态规划
        System.out.println("[");
        for (String s : res1) {
            System.out.println("\"" +s + "\""+",");
        }
        System.out.println("]");

    }
}
