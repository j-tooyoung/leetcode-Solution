
/**
 * ClassName: lc125
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:40
 * @author: tooyoung
 */

public class lc125 {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while (i < j) {
            // 越界 ".,"
//            while (!Character.isLetterOrDigit(ch[i])) {
            while (i< j && !Character.isLetterOrDigit(ch[i])) {
                i++;
            }
            while (i< j && !Character.isLetterOrDigit(ch[j])) {
                j--;
            }
            if (Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public boolean isPalindrome1(String s) {
        if(s.length() == 0) return true;

        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]", ""));

        return sb.toString().equals(sb.reverse().toString());
    }
     public static void main(String[] args) {

    }
}
