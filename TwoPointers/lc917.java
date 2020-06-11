import java.util.ArrayList;
import java.util.List;

/**
 * 917. 仅仅反转字母
 * https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class lc917 {

    public static String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] ch = S.toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetter(ch[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(ch[j])) {
                j--;
            }
            if (i < j) {
                swap(ch, i, j);
            }
            i++;
            j--;
        }

        return String.valueOf(ch);
    }

    private static void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ab-cd");
        list.add("a-bC-dEf-ghIj");
        list.add("Test1ng-Leet=code-Q!");
        for (String s : list) {
            System.out.println(reverseOnlyLetters(s));
        }
    }
}
