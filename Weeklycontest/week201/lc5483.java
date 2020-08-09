package week201;

import java.util.LinkedList;

/**
 * 5483. 整理字符串
 * https://leetcode-cn.com/contest/weekly-contest-201/problems/make-the-string-great/
 */
public class lc5483 {

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        LinkedList<Character> st = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && Math.abs(ch - st.getLast()) == 32) {
               st.removeLast();
            } else {
                st.addLast(ch);
            }
        }
        for (Character ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static boolean isValid(char ch1, char ch2) {
        if (Math.abs(ch1 - ch2) == 32) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "Pp";
        String s1 = "mC";
//        System.out.println(makeGood(s));
        System.out.println(makeGood(s));
        System.out.println('a'-'A');
        System.out.println('a'-'Z');
    }

}
