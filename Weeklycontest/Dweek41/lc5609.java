package Dweek41;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname lc5666
 * @Description
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5609 {


    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int cnt = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }

}
