import java.util.Arrays;

/**
 * 面试题 05.07. 配对交换
 * https://leetcode-cn.com/problems/exchange-lcci/
 *
 */
public class lc0507 {

    // 位运算
//    分别取出数字二进制奇数位和偶数位
//    将奇数位的二进制放在偶数位（即右移
//    将偶数位的二进制放在奇数位（即左移
//    对于奇数位，使用 101010（即 0xAA）作为掩码，提取奇数位，并把它们右移一位；
//    对于偶数位，使用 010101（即 0x55）作为掩码，提取偶数位，并把它们左移一位。
//
//    作者：z1m
//    链接：https://leetcode-cn.com/problems/exchange-lcci/solution/cong-bu-tong-de-jiao-du-kao-lu-bing-qi-chuan-tong-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static int exchangeBits(int num) {
        int even = (num & 0xaaaaaaaa) >> 1;
        int odd = (num & 0x55555555) << 1;
        return even | odd;
    }

    // num
    public static int exchangeBits1(int num) {
        String s = Integer.toBinaryString(num);
        char[] ch = s.toCharArray();
        // 设为32的数组，就爆出number of exception错误
        char[] res = new char[31];
        int idx = 30;
        for (int i = ch.length - 1; i > 0; i -= 2) {
//            swap(ch, i, i - 1);
            res[idx--] = ch[i - 1];
            res[idx--] = ch[i];
        }
        if (ch.length % 2 != 0) {
            res[idx--] = '0';
            res[idx--] = ch[0];
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (res[i] == 0) continue;
            ans = ans * 2 + (res[i] - '0');
        }
        return ans;
//        System.out.println(res.toString());
//        System.out.println(String.valueOf(res));
//        return Integer.valueOf(res.toString(), 2);
//        return Integer.valueOf(String.valueOf(res), 2);
    }

    private void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(1 + " " + exchangeBits(1));
        System.out.println(10 + " " + exchangeBits(10));

//        System.out.println(Integer.valueOf("01",2));
//        System.out.println(Integer.valueOf("001",2));
//        System.out.println(Integer.valueOf("101",2));
//        char[] ch = {'0', '1'};
//        System.out.println(String.valueOf(ch));
//
//        for (int i = 1; i < 20; i++) {
//            System.out.println(i + " " + exchangeBits(i));
////            System.out.println(Integer.toBinaryString(i));
//        }
    }

}
