package Dweek40;

/**
 * @Classname lc5664
 * @Description
 * @Date 2020/11/15 23:43
 * @Created by j-tooyoung
 */
public class lc5557 {

    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())) {
            sb.append(word);
            ans++;
        }
        return ans;
    }

    // KMP算法
    public int maxRepeating1(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) return 0;
//        String pattern = new String();
        char[] pattern = new char[n];
        for (int i = 0; i < m; i++) {
            pattern[i] = word.charAt(i);
        }
        for (int i = m; i < n; i++) {
            pattern[i] = pattern[i - m];
        }
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 1, j = -1; i < n; i++) {
            while (j > -1 && pattern[i] != pattern[j + 1]) {
                j = next[j];
            }
            if (pattern[i] == pattern[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        int ans = 0;

        for (int i = 0, j = -1; i < n; i++) {

            while (j > -1 && sequence.charAt(i) != pattern[j + 1]) {
                j = next[j];
            }
            if (sequence.charAt(i) == pattern[j + 1]) {
                j++;
            }
            ans = Math.max(ans, (j + 1) / m);
        }

        return ans;
    }
}
