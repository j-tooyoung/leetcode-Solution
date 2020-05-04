import java.util.Arrays;

/**
 * 5385. 改变一个整数能得到的最大差值
 */
public class lc5385 {

    public static int maxDiff(int num) {
        String s = String.valueOf(num);
        char[] ch = s.toCharArray();
        char[] ch1 = Arrays.copyOf(ch, ch.length);
        char c = '0';
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] - '0' < 9) {
                c = ch[i];
                break;
            }
            if (ch[i] -'0' == 1) continue;
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == c) {
                ch[i] = '9';
            }
        }
        int maxVal = Integer.valueOf(String.valueOf(ch));
        int idx = 0;

        for (int i = 0; i < ch1.length; i++) {
            if (i == 0 && ch1[i] == '1') continue;
            if (ch1[i] == '0') continue;
            else {
                if (ch1[i] == ch1[0] && ch1[0] == '1') {
                    continue;
                } else {
                    idx = i;
                    c = ch1[i];
                    break;
                }

            }
        }

        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == c) {
                if (ch1[0] == ch1[i] || idx == 0) {
                    ch1[i] = '1';
                } else {
                    ch1[i] = '0';
                }
            }
        }
        int minVal = Integer.valueOf(String.valueOf(ch1));
        return maxVal - minVal;
    }

    public static void main(String[] args) {
        int[] nums = {555, 9, 123456, 10000, 9288,1101057};
        for (int val : nums) {
            System.out.println(maxDiff(val));
        }
        System.out.println(9909057 - 1101007);
      //  System.out.println(Integer.MAX_VALUE > 10e8);
    }
}
