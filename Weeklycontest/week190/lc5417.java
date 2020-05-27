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

    public static int maxVowels1(String s, int k) {
//        i指针在后，j指针在前，当j~i的长度大于k时将j向后移动，并判断是否为元音，来修改当前窗口元音的数量，若区间i~j的长度等于k则更新答案。
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int res = 0;
        int cnt = 0;
        int len = s.length();
        // i,j双指针
        for (int i = 0, j = 0; i < len; i++) {
            if (i - j + 1 > k) {
                if (set.contains(s.charAt(j))) cnt--;
            }
            if (set.contains(s.charAt(i))) cnt++;
            if (i - j + 1 == k) res = Math.max(res, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }
}
