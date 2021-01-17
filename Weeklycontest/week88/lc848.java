package week88;

/**
 * @Classname lc848
 * @Description
 * @Date 2021/1/15 12:41
 * @Created by j-tooyoung
 */
public class lc848 {
    public String shiftingLetters(String S, int[] shifts) {
        int len = S.length();
        char[] ch = S.toCharArray();
        int total = 0;
        for (int i = len - 1; i >= 0; i--) {
            total += shifts[i];
            total %= 26;
            ch[i] = (char) ((ch[i] - 'a' + total) % 26 + 'a');

        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(('c' + 9) % 26);
        System.out.println('l' - 'c');
        System.out.println('c' + 9);
        System.out.println((int) ('a'));

    }
}
