package week221;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5637 {

    public boolean halvesAreAlike(String s) {
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
        int len = s.length();
        int cnt = 0;
        int cnt2 = 0;
        for (int i = 0; i < len / 2; i++) {
            cnt = (set.contains(s.charAt(i))) ? cnt + 1 : cnt;
        }
        for (int i = len / 2; i < len; i++) {
            cnt2 = (set.contains(s.charAt(i))) ? cnt2 + 1 : cnt2;
        }
        return cnt == cnt2;
    }

}
