import java.util.*;

/**
 * 500. 键盘行
 * https://leetcode-cn.com/problems/keyboard-row/
 *
 */
public class lc500 {

    public String[] findWords(String[] words) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        Set<Character> s3 = new HashSet<>();

        s1.add('q');
        s1.add('w');
        s1.add('e');
        s1.add('r');
        s1.add('t');
        s1.add('y');
        s1.add('u');
        s1.add('i');
        s1.add('o');
        s1.add('p');

        s2.add('a');
        s2.add('s');
        s2.add('d');
        s2.add('f');
        s2.add('g');
        s2.add('h');
        s2.add('j');
        s2.add('k');
        s2.add('l');

        s3.add('z');
        s3.add('x');
        s3.add('c');
        s3.add('v');
        s3.add('b');
        s3.add('n');
        s3.add('m');

        List<String> res = new ArrayList<>();
        String[] ans;
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i].toLowerCase();
            // System.out.println(tmp);

            char ch = tmp.charAt(0);
            boolean flag = true;
            if (s1.contains(ch)) {
                for (int j = 0; j < tmp.length(); j++) {
                    if (!s1.contains(tmp.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
            } else if (s2.contains(ch)) {
                for (int j = 0; j < tmp.length(); j++) {
                    if (!s2.contains(tmp.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < tmp.length(); j++) {
                    if (!s3.contains(tmp.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res.add(words[i]);
            }
        }
        ans = new String[res.size()];
        return res.toArray(ans);
    }
}
