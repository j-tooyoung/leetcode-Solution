import java.util.Arrays;

/**
 * 5386. 检查一个字符串是否可以打破另一个字符串
 */
public class lc5386 {


    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean flag = true;
        if (c1[0] > c2[0]) {
            for (int i = 0; i < c1.length; i++) {

                if (c1[i] >= c2[i]) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            if (flag) return true;
        } else {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] <= c2[i]) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            if (flag) return true;
        }
        return false;
    }

    public static boolean checkIfCanBreak1(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean flag = true;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] > c2[i]) {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        flag = true;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] < c2[i]) {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        return false;
    }



    public static void main(String[] args) {
        String s1 = "abc", s2 = "xya";
        String s21 = "abe", s22 = "acd";
        String s31 = "leetcodee", s32 = "interview";
        String s41 = "bxfowqvnrhuzwqohquamvszkvunb", s42 = "xjegbjccjjxfnsiearbsgsofywtq";
        System.out.println(checkIfCanBreak(s1, s2));
        System.out.println(checkIfCanBreak(s21, s22));
        System.out.println(checkIfCanBreak(s31, s32));
        System.out.println(checkIfCanBreak(s41, s42));
//        System.out.println('x' > 'y');
//        System.out.println('a' > 'y');

    }

}
