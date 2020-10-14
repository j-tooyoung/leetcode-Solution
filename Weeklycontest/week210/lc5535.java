package week210;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Classname lc5134
 * @Description
 * @Date 2020/10/4 13:54
 * @Created by j-tooyoung
 */
public class lc5535 {

    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        if (chars.length == 0) return 0;
        int ans = 0;
        int depth = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                st.push(chars[i]);
                depth = 0;
            } else if (chars[i] == ')') {
                Character pop = st.pop();
                if (pop != '(') {
                    return 0;
                }
                depth++;
            }
            ans = Math.max(ans, depth);
        }
        return ans;

    }
}
