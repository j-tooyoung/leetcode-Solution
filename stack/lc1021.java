import java.util.LinkedList;

/**
 * 1021. 删除最外层的括号
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class lc1021 {
//
//    result字符串保存结果
//            遍历字符串
//    左括号入栈：若入栈后栈的长度大于1，即该左括号不是原语首个左括号，结果加入'('
//    右括号出栈：若出栈后栈的长度大于0，即该右括号不是原语末个右括号，结果加入')'
//
//    作者：dapao
//    链接：https://leetcode-cn.com/problems/remove-outermost-parentheses/solution/ji-jian-si-lu-pythonzhan-by-dapao/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String removeOuterParentheses(String S) {
        LinkedList<Character> st = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                st.addLast(ch);
                if (st.size() > 1) {
                    sb.append(ch);
                }
            } else {
                st.pop();
                if (st.size() > 0) {
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
