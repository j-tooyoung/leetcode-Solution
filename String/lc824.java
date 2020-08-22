import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 824. 山羊拉丁文
 * https://leetcode-cn.com/problems/goat-latin/
 *
 */
public class lc824 {

    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] s = S.split(" ");
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
        for (int i = 0; i < s.length; i++) {
            String tmp = s[i];
            if (set.contains(tmp.charAt(0))) {
                sb.append(tmp).append("ma");
                for (int j = 0; j <= i; j++) {
                    sb.append("a");
                }
                if (i < s.length - 1) sb.append(" ");
            } else {
                sb.append(tmp.substring(1)).append(tmp.charAt(0)).append("ma");
                for (int j = 0; j <= i; j++) {
                    sb.append("a");
                }
                if (i < s.length - 1) sb.append(" ");
            }

        }
        return sb.toString();
    }
}
