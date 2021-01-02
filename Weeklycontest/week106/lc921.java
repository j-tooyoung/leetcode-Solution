package week106;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname lc921
 * @Description
 * @Date 2021/1/2 15:49
 * @Created by j-tooyoung
 */
public class lc921 {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(S.charAt(i));
                }
            } else {
                stack.add(S.charAt(i));
            }
        }
        return stack.size();
    }

}
