import java.util.Arrays;

/**
 * 738. 单调递增的数字
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class lc738 {

    // 贪心
    // 100 99
    //从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
    //  则把其左边一位数字减1，并将该位及其右边的所有位改成9
    public static int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        int length = s.length();
        char[] chars = s.toCharArray();
        int flag = length;
        for (int i = length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
//        char[] ch = String.valueOf(N).toCharArray();
//        int len = ch.length;
//        for (int i = ch.length - 1; i > 0; i--) {
//            if (ch[i] < ch[i - 1]) {
//                ch[i - 1] -= 1;
//                for (int j = i; j < len; j++) {
//                    ch[j] = '9';
//                }
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < ch.length; i++) {
//            res = res * 10 + ch[i] - '0';
//        }
//        return  res;
//        return Integer.parseInt(Arrays.toString(ch));  有前置O
    }

    // 暴力法 超时
    public static int monotoneIncreasingDigits1(int N) {
        int res = 0;
        for (int i = N; i >= 0; i--) {
            if (isValid(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    private static boolean isValid(int i) {
        String s = String.valueOf(i);
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.charAt(j) > s.charAt(j + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": " + monotoneIncreasingDigits(i));
        }
    }
}
