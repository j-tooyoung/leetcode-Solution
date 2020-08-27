package week154;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * https://leetcode-cn.com/contest/weekly-contest-154/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class lc1190 {

    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) == ')') {
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                String tmp = sb.toString();
                for (int j = 0; j < tmp.length(); j++) {
                    st.add(tmp.charAt(j));
                }
            } else {
                st.add(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }


}
