package Dweek43;

import java.util.Stack;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5634 {


    public int maximumGain(String s, int x, int y) {
        int res = 0;
        char[] ch = s.toCharArray();
        int n = s.length();
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'a') {
                    ch[i] = 'b';
                }else if (ch[i] == 'b') {
                    ch[i] = 'a';
                }
            }
        }

        for (int i = 0; i < n; ) {
            while (i < n && ch[i] != 'a' && ch[i] != 'b') {
                i++;
            }

            int j = i ;
            int ca = 0, cb = 0;
            while (j < n && (ch[j] == 'a' || ch[j] == 'b')) {
                if (ch[j] == 'a') {
                    ca++;
                }
                if (ch[j] == 'b') {
                    cb++;
                    //   System.out.println(ca + " " + cb);

                    if (ca > 0) {
                        ca--;
                        cb--;
                        res += x;
                    }
                }
                j++;

            }
            res += Math.min(ca, cb) * y;
            i = j;
        }
        return res;
    }

}
