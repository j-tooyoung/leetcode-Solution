import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: lc345
 * Package: PACKAGE_NAME
 * Description:
 * 345. 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * @date: 2020/4/8 22:41
 * @author: tooyoung
 */

public class lc345 {

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            while (!set.contains(ch[i])) {
                i++;
            }
            while (!set.contains(ch[j])) {
                j--;
            }
            if (i < j) {
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
            }
            i++;
            j--;
        }
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String reverseVowels1(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while (i < j) {
            while (!set.contains(ch[i])) {
                i++;
            }
            while (!set.contains(ch[j])) {
                j--;
            }
            if (i < j) {
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
            }
            i++;
            j--;
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        int a = 'a' - 'A';
        System.out.println(a);
        String s = ".,";
        lc345 lc345 = new lc345();
        System.out.println(lc345.reverseVowels(s));
    }
}
