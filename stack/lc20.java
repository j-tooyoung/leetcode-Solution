import java.util.*;

/**
 * ClassName: lc20
 * Package: PACKAGE_NAME
 * Description:
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @date: 2020/4/8 23:10
 * @author: tooyoung
 */

public class lc20 {

    // 字符串替代，"()"替代为”“
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        LinkedList<Character> st = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                st.addLast(ch);
            } else {
                //
                if (st.isEmpty() || ch != map.get(st.getLast())) {
                    return false;
                } else {
                    st.removeLast();
                }
            }
        }
        return st.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 =  "()[]{}";
        String s2 = "(]";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
    }

}
