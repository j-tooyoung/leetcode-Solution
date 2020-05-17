package week189;

import java.util.*;

/**
 * 5413. 重新排列句子中的单词
 * https://leetcode-cn.com/contest/weekly-contest-189/problems/rearrange-words-in-a-sentence/
 */
public class lc5413 {
    public static String arrangeWords(String text) {
        StringBuilder sb = new StringBuilder();
        String[] s = text.split(" ");
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < s.length - 1; i++) {
            if (i == 0) {
                char[] ch = s[i].toCharArray();
                if (ch[0] >= 'a' && ch[0] <= 'z') ch[0] -= 32;
                sb.append(ch).append(" ");
            }else{
                char[] ch = s[i].toCharArray();
                if (ch[0] >= 'A' && ch[0] <= 'Z') ch[0] += 32;
                sb.append(ch).append(" ");
            }
        }
        char[] ch = s[s.length - 1].toCharArray();
        if (ch[0] >= 'A' && ch[0] <= 'Z') ch[0] += 32;
        sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "on";
        char[] ch = s.toCharArray();
        System.out.println(ch[0] + " " + String.valueOf(ch));
        if (ch[0] >= 'a' && ch[0] <= 'z') ch[0] -= 32;
//       Character.toUpperCase(ch[0]);
        System.out.println(ch[0]);
//        List<String> texts = new ArrayList<>();
////        texts.add("To be or not to be");
//        texts.add("Keep calm and code on");
////        texts.add("Leetcode is cool");
//        for (String s : texts) {
//            System.out.println(arrangeWords(s));
//        }
    }

}
