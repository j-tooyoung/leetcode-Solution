package week126;

import java.util.Stack;

/**
 * @Classname lc1003
 * @Description
 * @Date 2021/1/11 11:29
 * @Created by j-tooyoung
 */
public class lc1003 {

    // todo if else 太多
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (!st.isEmpty()) {
                    char c1 = st.pop();
                    char c2 = '0';
                    if (!st.isEmpty()) {
                        c2 = st.peek();
                    }
                    if (c1 == 'b' && c2 == 'a') {
                        st.pop();
                    } else {
                        st.push(c1);
                        st.push(s.charAt(i));
                    }
                } else {
                    st.push(s.charAt(i));
                }
            } else {
                st.push(s.charAt(i));
            }

        }
        return st.isEmpty();
    }

}
