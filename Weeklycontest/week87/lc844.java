package week87;

import java.util.Stack;

/**
 * @Classname lc844
 * @Description
 * @Date 2021/1/14 10:18
 * @Created by j-tooyoung
 */
public class lc844 {
    public boolean backspaceCompare(String S, String T) {
        int len = S.length() ;
//        int i = len - 1;
//        int j = T.length() - 1;
//        while (i >= 0 && j >= 0) {
//            if (S.charAt(i) != '#') {
//                if (S.charAt(i) != T.charAt(j)) {
//                    return false;
//                }
//            }
//        }
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            } else {
                st1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            } else {
                st2.push(T.charAt(i));
            }
        }
        if (st1.size() != st2.size()) {
            return false;
        }
        while (!st1.isEmpty()) {
            if (st1.pop() != st2.pop()) {
                return false;
            }
        }
        return true;
    }

    // 空间复杂度为1
    public boolean backspaceCompare1(String S, String T) {
        int len = S.length();
        int i = len - 1;
        int j = T.length() - 1;
        while (i >= 0 && j >= 0) {
            // 逻辑有误
            while (i >= 0 && S.charAt(i) == '#') {
                i -= 2;
            }
            while (j >= 0 && T.charAt(j) == '#') {
                j -= 2;
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else if (i < 0 && j < 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;

    }

}
