import java.util.Arrays;

/**
 * 面试题58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 */
public class lc58_11 {

    public String reverseLeftWords(String s, int n) {
        char[] ch = s.toCharArray();
        if (s == null || s.length() <= 1) return s;
        reverse(ch, 0, n - 1);
        reverse(ch, n, ch.length - 1);
        reverse(ch, 0, ch.length - 1);
//        return Arrays.toString(ch);
        return new String(ch);
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

    }

}
