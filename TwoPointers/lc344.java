/**
 * ClassName: lc344
 * Package: PACKAGE_NAME
 * Description:
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 * @date: 2020/4/8 22:41
 * @author: tooyoung
 */

public class lc344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

    }
}
