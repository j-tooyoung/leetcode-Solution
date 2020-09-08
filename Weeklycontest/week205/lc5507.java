package week205;

/**
 * @Classname lc507
 * @Description TODO
 * @Date 2020/9/6 10:33
 * @Created by xp123
 * https://leetcode-cn.com/contest/weekly-contest-205/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * 5507. 替换所有的问号
 */
public class lc5507 {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '?') {
                char prev = 0, next = 0;
                if (i >= 1){
                    prev = chars[i - 1];
                }
                if (i + 1< len){
                     next = chars[i + 1];
                }
                char ch = 'a';
                while(ch == prev || ch == next){
                    ch++;
                }
                chars[i] = ch;
            }
        }
        return String.valueOf(chars);
    }
}
