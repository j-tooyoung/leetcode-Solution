import java.util.Arrays;

/**
 * 面试题 05.07. 配对交换
 * https://leetcode-cn.com/problems/exchange-lcci/
 *
 */
public class lc0507 {

    public static int exchangeBits(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        char[] res = new char[32];
        int idx = 31;
        for (int i = ch.length - 1; i > 0; i -= 2) {
//            swap(ch, i, i - 1);
            res[idx--] = ch[i - 1];
            res[idx--] = ch[i];
        }
        if (ch.length % 2 != 0) {
            res[idx--] = ch[0];
            res[idx--] = 0;
        }
//        System.out.println(res.toString());
//        System.out.println(String.valueOf(res));
//        return Integer.valueOf(res.toString(), 2);
        return Integer.valueOf(String.valueOf(res), 2);
    }

    private void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("01",2));
        System.out.println(Integer.valueOf("001",2));
        System.out.println(Integer.valueOf("101",2));
        char[] ch = {'0', '1'};
        System.out.println(String.valueOf(ch));

        for (int i = 1; i < 20; i++) {
            System.out.println(i + " " + exchangeBits(i));
//            System.out.println(Integer.toBinaryString(i));
        }
    }

}
