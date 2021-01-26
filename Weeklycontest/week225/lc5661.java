package week225;

import java.util.*;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5661 {

    public String maximumTime(String time) {
        char[] ch = time.toCharArray();
        // System.out.println(ch[0] + " " + ch[1]);

        if (ch[0] == '?' && ch[1] == '?') {
            ch[0] = '2';
            ch[1] = '3';
        } else if (ch[0] == '?') {
            ch[0] = (ch[1] <= '3') ? '2' : '1';
        } else if (ch[1] == '?') {
            ch[1] = (ch[0] < '2') ? '9' : '3';
        }
        if (ch[3] == '?' && ch[4] == '?') {
            ch[3] = '5';
            ch[4] = '9';
        } else if (ch[3] == '?') {
            ch[3] = '5';
        } else if (ch[4] == '?') {
            ch[4] = '9';
        }
        return new String(ch);
    }

}
