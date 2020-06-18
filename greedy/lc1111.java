import java.util.Arrays;
import java.util.LinkedList;

/**
 * 1111. 有效括号的嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */
public class lc1111 {

    public static int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
//        char[] ch = seq.toCharArray();
        int[] res = new int[len];
        LinkedList<Character> st = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (seq.charAt(i) == '(') {
//            if (ch[i] == '(') {
                cnt++;
//                res[i] = cnt % 2 != 0 ? 0 : 1;
                res[i] = (cnt & 1) != 0 ? 0 : 1;
            } else {
                cnt--;
                res[i] = (cnt & 1) != 0 ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String seq = "(()())";
        System.out.println(Arrays.toString(maxDepthAfterSplit(seq)));

    }

}
