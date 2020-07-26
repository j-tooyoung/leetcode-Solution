package Week199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5473. 灯泡开关 IV
 * https://leetcode-cn.com/contest/weekly-contest-199/problems/bulb-switcher-iv/
 */
public class lc5473 {

    // 1和中间零的个数，还需考虑前置1和后置零
    public static int minFlips(String target) {
        int res = 0;
        int len = target.length();
        boolean flag = (target.charAt(0) == '0');
        boolean flag1 = (target.charAt(len - 1) == '0');
        for (int i = 0; i < len; ) {
            if (target.charAt(i) == '0') {
                i++;
                continue;
            } else {
                while (i < len && target.charAt(i) == '1') {
                    i++;
                }
                res++;
            }
        }
//        System.out.println(res);
        if (res == 0) return res;
        else if (res == 1) return flag ? res : res * 2;
        if (flag1) {
            return res * 2;
        }
        return res * 2 - 1;
    }

    public static int minFlips1(String target) {
        return 0;
    }

    public static void main(String[] args) {
//        String s = "010011101";
//        String s1 = "00111";
//        String s2 ="0100111010";
//        System.out.println(minFlips(s));
//        System.out.println(minFlips(s1));
//        System.out.println(minFlips(s2));   //6

        List<String> list = Arrays.asList("10111",
                "101",
                "00000",
                "001011101",
                "1001011101",
                "1100",
                "010011101",
                "00111","0100111010");
//                new ArrayList<>({});
        for (String s : list) {
            System.out.println(minFlips(s));
        }
    }

}
