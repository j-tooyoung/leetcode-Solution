/**
 * 821. 字符的最短距离
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 *
 */
public class lc821 {

    //对于每个字符 S[i]，试图找出距离向左或者向右下一个字符 C 的距离。答案就是这两个值的较小值。
    //
    //算法
    //
    //从左向右遍历，记录上一个字符 C 出现的位置 prev，那么答案就是 i - prev。
    //
    //从右想做遍历，记录上一个字符 C 出现的位置 prev，那么答案就是 prev - i。
    //
    //这两个值取最小就是答案。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character/solution/zi-fu-de-zui-duan-ju-chi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] res = new int[len];
        int prev = -10005;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                res[i] = 0;
                prev = i;
            } else {
                res[i] = i - prev;
            }
        }
        int next = 10005;
        for (int i = len - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                res[i] = 0;
                next = i;
            } else {
                res[i] = Math.min(next - i, res[i]);
            }
        }
        return res;
    }

    public int[] shortestToChar1(String S, char C) {
        int len = S.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                res[i] = 0;
            } else {
                int lo = i - 1, hi = i + 1;
                while (lo >= 0 && S.charAt(lo) != C) {
                    lo--;
                }
                while (hi < len && S.charAt(hi) != C) {
                    hi++;
                }
                if (lo < 0) {
                    res[i] = hi - i ;
                    continue;
                }
                if (hi >= len) {
                    res[i] = i - lo ;
                    continue;
                }
                res[i] = Math.min(i - lo, hi - i) ;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] res = new lc821().shortestToChar(s, c);
        System.out.println(String.valueOf(res));

    }
}
