import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: lc151
 * Package: PACKAGE_NAME
 * Description:
 * 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @date: 2020/4/10 15:04
 * @author: tooyoung
 */

public class lc151 {

    public static void main(String[] args) {
        final lc151 lc151 = new lc151();
        String s = "  hello world!  ";
        String s1 = "  hello  world!  ";
        System.out.println(s1.substring(0,3));
//        s = lc151.reverseWords(s);
//        System.out.println(s);
//        s1 = lc151.reverseWords(s1);
        s1 = lc151.reverseStringBF(s1);
        System.out.println(s1);
    }

    //API
    public String reverseStringBF(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s++"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    //遍历
    public String reverseWords(String s) {
        String res = "";
        for (int i = s.length() - 1, j = s.length() - 1; i >= 0; ) {
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
                i--;
            }
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            res += s.substring(j + 1, i+1)+" ";
            // System.out.println(res);
            i = j;
        }
        return res.trim(); //去除最后的空格
    }


}
