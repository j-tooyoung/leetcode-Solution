/**
 * @Classname lc557
 * @Description TODO
 * @Date 2020/8/30 8:45
 * @Created by xp123
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 */
public class lc557 {

    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int len = s.length();
        int count = 0;
        for(int i = 0;i < len;i++) {
            if(ch[i] == ' ') {
                reverse(ch,i-count,i-1);
                count = 0;
            } else {
                count++;
            }
        }
        reverse(ch,len-count,len-1);
        return new String(ch);
    }

    public void reverse(char[] ch,int begin,int end) {
        while(begin < end) {
            char tmp = ch[begin];
            ch[begin] = ch[end];
            ch[end] = tmp;
            begin++;
            end--;
        }
    }

    public String reverseWords1(String s) {
         String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = s1.length;
        for (int i = 0; i < s1.length; i++) {
            sb.append(reverse(s1[i]));
            if (i < len - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String reverse(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
