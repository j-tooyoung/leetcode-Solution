package Week199;

import java.util.Arrays;

/**
 * 5472. 重新排列字符串
 * https://leetcode-cn.com/contest/weekly-contest-199/problems/shuffle-string/
 */
public class lc5472 {

    //  wrong answer
    public static String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int len = indices.length;
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            while (indices[i] != i && !used[i] && !used[indices[i]]) {
                swap(ch, indices[i], i);
                used[indices[i]] = true;
                i = indices[i];
                System.out.println(i + " " + indices[i]);
            }
        }
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String restoreString1(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int len = indices.length;
        for (int i = 0; i < len; i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return new String(ch);
//        for (char c : ch) {
//            sb.append(c);
//        }
//        return sb.toString();
    }

    private static void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "aiohn";
        String s1 = "codeleet";
        int[] indices = {3, 1, 4, 2, 0};
        int[] indices1 = {4,5,6,7,0,2,1,3};
//        System.out.println(restoreString(s, indices));
        System.out.println(restoreString1(s1, indices1));
    }

}
