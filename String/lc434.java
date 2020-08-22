/**
 * 434. 字符串中的单词数
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 *
 */
public class lc434 {

    public static int countSegments(String s) {
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; ) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= len) break;
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        String s = "Hello, my name is John";
        String s1 = "               ";
        System.out.println(countSegments(s1));
//        System.out.println(countSegments(s));
    }

}
