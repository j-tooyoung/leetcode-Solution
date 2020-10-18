package week211;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc5544 {

    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        Queue<String> q = new LinkedList<>();
        q.add(s);
        Set<String> set = new HashSet<>();
        set.add(s);
        while (!q.isEmpty()) {
            String s1 = q.poll();
            if (ans.compareTo(s1) < 0) {
                ans = s1;
            }

            char[] ch = s1.toCharArray();
            for (int i = 1; i < ch.length; i += 2) {
                int num = (ch[i] - '0' + a);
                if ((ch[i] - '0' + a) >= 10) {
                    num -= 10;
                }
                ch[i] = (char) (48 + num);
            }
            String s2 = new String(ch);
            if (!set.contains(s2)) {
                q.add(s2);
                set.add(s2);
            }

            s1 = s1.substring(b) + s1.substring(0, b);
            if (!set.contains(s1)) {
                q.add(s1);
                set.add(s1);
            }
        }
        return ans;
    }

}
