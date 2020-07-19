/**
 * 821. 字符的最短距离
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 *
 */
public class lc821 {

    public int[] shortestToChar(String S, char C) {
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
