package Dweek44;

import java.util.Stack;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5634 {


    public int maximumGain(String s, int x, int y) {
        int res = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (!st.isEmpty() && st.peek() == 'b') {
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'b' && x > y) {
                        st.push(s.charAt(i));
                    } else {
                        System.out.println(i + " " + y);
                        res += y;
                        st.pop();
                    }

                } else {
                    st.push(s.charAt(i));
                }

            } else if (s.charAt(i) == 'b') {
                if (!st.isEmpty() && st.peek() == 'a') {
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'a' && x < y) {
                        st.push(s.charAt(i));
                    } else {
                        System.out.println(i + " " + x);
                        res += x;
                        st.pop();
                    }

                } else {
                    st.push(s.charAt(i));
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {
            char c1 = st.pop();
            char c2 = st.pop();
            if (c1 == 'a' && c2 == 'b') {
                res += y;
            }
            if (c2 == 'a' && c1 == 'b') {
                res += x;
            }
        }
        return res;
    }

}
