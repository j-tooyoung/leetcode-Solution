package Week220;

import java.util.Arrays;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5629 {

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            }
        }
        String s = sb.toString();
        System.out.println(s);

        int len = s.length();
        for (int i = 0; i < len; i += 3) {
            if (len - i == 4) {
                res.append(s.substring(i, i + 2));
                res.append("-");
                res.append(s.substring(i + 2, len));
                break;
            } else if (len - i == 2) {
                res.append(s.substring(i, len));
                break;
            } else if (len - i == 3) {
                res.append(s.substring(i, len));
                break;
            }
            res.append(s.substring(i, i + 3));
            res.append("-");

        }
        return res.toString();
    }

}
