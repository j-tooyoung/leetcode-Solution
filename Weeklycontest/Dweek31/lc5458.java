package Dweek31;

import java.util.HashSet;
import java.util.Set;

/**
 * 5458. 字符串的好分割数目
 * https://leetcode-cn.com/contest/biweekly-contest-31/problems/number-of-good-ways-to-split-a-string/
 */
public class lc5458 {

    public static int numSplits(String s) {
        int res = 0;
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!set.contains(ch[i])) {
                set.add(ch[i]);
                left[i] += set.size();
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (!set2.contains(ch[i])) {
                set2.add(ch[i]);
                right[i] += set2.size();
            } else {
                right[i] = right[i + 1];
            }
        }
        for (int i = 0; i < len -1; i++) {
//            System.out.println(left[i] + " " + right[i]);
            if (left[i] == right[i + 1]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aacaba";
        String s1 = "abcd";
        String s2 = "aaaaa";
        String s3 = "acbadbaada";
        System.out.println(numSplits(s));
        System.out.println(numSplits(s1));
        System.out.println(numSplits(s2));
        System.out.println(numSplits(s3));
    }

}
