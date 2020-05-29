import java.util.Map;

/**
 * 面试题 05.03. 翻转数位
 * https://leetcode-cn.com/problems/reverse-bits-lcci/
 */
public class lc0503 {

    // java 用0将连续的1分成许多小块，将1的个数存在数组中，最后求数组两个相邻和的最大值，加1即为最大长度
    public static int reverseBits(int num) {
        int[] cnt = new int[1000];
        int idx = 0;
        int res = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                cnt[idx]++;
            } else {
                idx++;
            }
            num >>= 1;
        }
        for (int i = 0; i <= idx; i++) {
            res = Math.max(res, cnt[i] + cnt[i + 1] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {

        }
    }

}
