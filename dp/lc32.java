import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: lc32
 * Package: PACKAGE_NAME
 * Description:
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @date: 2020/4/8 22:55
 * @author: tooyoung
 */

public class lc32 {

    public static int longestValidParentheses(String s) {
        // 遇到左括号入账，右括号出栈，将坐标入栈
        LinkedList<Integer> st = new LinkedList<>();
        int res = 0;
        st.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.addLast(i);
            } else {
                st.pollLast();
                if (st.isEmpty()) {
                    st.addLast(i);
                } else {
//                    System.out.println(i - st.getLast());
                    res = Math.max(res, i - st.getLast());
                }
            }
        }
        return res;
    }


    public static int longestValidParentheses1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int res = 0;
        char[] ch = s.toCharArray();
        if (ch[0] == '(' && ch[1] == ')') {
            dp[0] = 1;
            dp[0] = 1;
        }
        for (int i = 2; i < len; i++) {
            if (ch[i - 2] == '(' && ch[i - 1] == ')') {
                dp[i] = dp[i - 2] + 2;
            } else {
                dp[i] = 0;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(())";
        String s1 = ")()())";
        String s2 = "(()(()";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
    }
}
