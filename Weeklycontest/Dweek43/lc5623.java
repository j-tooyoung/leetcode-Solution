package Dweek43;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5623 {

    public String maximumBinaryString(String binary) {
        int idx = 0;
        int len = binary.length();
        while (idx < len &&binary.charAt(idx) == '1') {
            idx++;
        }
        if(idx == len) return binary;
        int cntOf1 = 0;
        for (int i = 0; i < len; i++) {
            if (binary.charAt(i) == '1') {
                cntOf1 += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int lowbitOf1 = cntOf1 - idx;
        int highOf1 = len- lowbitOf1 -1;
        for (int i = 0; i < highOf1; i++) {
            sb.append('1');
        }
        sb.append('0');
        for (int i = 0; i < lowbitOf1; i++) {
            sb.append('1');
        }

        return sb.toString();

    }
}
