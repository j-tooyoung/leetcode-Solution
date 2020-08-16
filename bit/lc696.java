import java.util.HashMap;
import java.util.Map;

/**
 * 696. 计数二进制子串
 * https://leetcode-cn.com/problems/count-binary-substrings/
 */
public class lc696 {

    // 一个简单的思路：用last来记录之前一种数字的个数， cur来记录当前数字的个数； 当last >= cur的时候， res ++; 具体代码如下
    public int countBinarySubstrings(String s) {
        int res = 0;
        int len = s.length();
        int last = 0;
        int cur = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                last = cur; cur= 1;
            }
            if (last >= cur) {
                res++;
            }
        }
        return res;
    }

    // 先统计连续的0和1分别有多少个，如：111100011000，得到4323；在4323中的任意相邻两个数字，取小的一个加起来，就是3+2+2 = 7.
    public int countBinarySubstrings1(String s) {
        int res = 0;
        int len = s.length();
        int cur = 0;
        int last = 0;
        while (cur < len) {
            char ch = s.charAt(cur);
            // 记录连续相同数的个数
            int count = 0;
            while (cur < len && ch == s.charAt(cur)) {
                count++;
                cur++;
            }
            res += Math.min(count, last);
            last = count;
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(0 ^ '0');
        System.out.println(0 ^ '1');
        System.out.println('0' ^ '1');
        System.out.println('1' ^ '1');
    }

}
