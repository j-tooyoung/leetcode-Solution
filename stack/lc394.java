
import java.util.LinkedList;

/**
 * 394. 字符串解码
 *  https://leetcode-cn.com/problems/decode-string/
 */
public class lc394 {

    public static String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if (isNumber(ch)) {
                while (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    num = num * 10 + s.charAt(i)  - '0';
                    i++;
                }
                numStack.addLast(num);
                continue;
            } else if (isString(ch)) {
                strStack.addLast(String.valueOf(ch));
            } else if (ch == '[') {
                strStack.addLast(String.valueOf(ch));
                num = 0;
            } else {
                int times = numStack.removeLast();
                System.out.println(times);
                // num置为0，重新计数
//                num = 0;
                StringBuilder sb1 = new StringBuilder();
                while (!strStack.isEmpty() && !strStack.getLast().equals("[")) {
                    sb1.append(reverse(strStack.removeLast()));
                }

                // 删除“【”
                if (!strStack.isEmpty()) strStack.removeLast();
                String tmp = sb1.reverse().toString();
//                System.out.println(tmp);
                 sb1 = new StringBuilder();
                while (times-- > 0) {
                    sb1.append(tmp);
                }
                strStack.addLast(sb1.toString());
            }
            i++;
        }
        for (String ch : strStack) {
            sb.append(ch);
        }
        return sb.toString();
//        return sb.toString().replaceAll("\\[","");
    }

    static String reverse(String tmp) {
        StringBuilder sb = new StringBuilder();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            sb.append(tmp.charAt(i));
        }
        return sb.toString();
    }

   static boolean isNumber(char ch) {
        return ch <= '9' && ch >= '0';
    }

    static boolean isString(char ch) {
        return (ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A');
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = "3[a2[c]]";
        String s2 = "2[abc]3[cd]ef";
        String s3 = "abc3[cd]xyz";
        String s4 = "10[leetcode]";
        String s5 = "3[a]2[b4[F]c]";
        String s6 ="3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s7 ="3[a10[bc]]";

        int[] arr = {0, 1, 1, 1, 1, 3, 4, 5};
//        for (int i = 0; i < arr.length; i++) {
//            while (arr[i] == 1) i++;
//            System.out.println(i);
//        }
//        System.out.println(String.valueOf('['));
        System.out.println(decodeString(s));
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
        System.out.println(decodeString(s4));
        System.out.println(decodeString(s5));
        System.out.println(decodeString(s6));
        System.out.println(decodeString(s7));

    }
}
