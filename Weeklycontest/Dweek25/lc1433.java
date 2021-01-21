package Dweek25;

import java.util.Arrays;

/**
 * @Classname lc1433
 * @Description
 * @Date 2021/1/21 10:21
 * @Created by j-tooyoung
 */
public class lc1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        System.out.println("ch1 = " + new String(ch1) + " " + "ch2 = " + new String(ch2) + " ");
        boolean flag1 = true;   // ch1[i]>ch2[i]
        boolean flag2 = true;   // ch1[i]< ch2[i]

//        for (int i = 0; i < ch1.length; i++) {
//            if (flag1 && ch1[i] < ch2[i]) {
//                flag1 = false;
//            }
//            if (flag2 && ch1[i] > ch2[i]) {
//                flag2 = false;
//            }
//            if (!flag1 && !flag2) {
//                return false;
//            }
//        }
//        return true;

        return IsContent(ch1, ch2) || IsContent(ch2, ch1);
    }

    private boolean IsContent(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] > chars2[i]) return false;
        }
        return true;
    }
}
