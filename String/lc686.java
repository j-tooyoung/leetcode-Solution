/**
 * 686. 重复叠加字符串匹配
 * https://leetcode-cn.com/problems/repeated-string-match/
 *
 */
public class lc686 {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int lenA = A.length();
        int lenB = B.length();
        if (lenA < lenB && !B.contains(A)) {
            return -1;
        }
        int cnt = 0;
        while (true) {
            ++cnt;
            sb.append(A);
            if (sb.toString().contains(B)) {
                return cnt;
            }
        }
    }
}
