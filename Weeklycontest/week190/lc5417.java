package week190;

import java.util.HashSet;
import java.util.Set;

/**
 * 5417. 定长子串中元音的最大数目
 * https://leetcode-cn.com/contest/weekly-contest-190/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class lc5417 {

    public static int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int j = 0;
        int len = 0;
        int cnt = 0;
        int res = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                cnt++;
            }
            j++;
            len++;
            if (len == k) {
//                System.out.println(j + "," + k);
                res = Math.max(res, cnt);
                if (set.contains(s.charAt(j - k))) {
                    cnt--;
                }
                len--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }
}
