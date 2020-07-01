import java.util.Arrays;
import java.util.Comparator;

/**
 * 1048. 最长字符串链
 * https://leetcode-cn.com/problems/longest-string-chain/
 */
public class lc1048 {

    public static int longestStrChain(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int len = words.length;
        int[] dp = new int[len];
        int res = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isValid(words, i, j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // words[j] 为words[i]的词链
    private static boolean isValid(String[] words, int i, int j) {
        int len1 = words[i].length();
        int len2 = words[j].length();
        if (len1 != len2 + 1){ return false;}
        int[] cnt = new int[128];
        for (char ch : words[i].toCharArray()) {
            cnt[ch]++;
        }
        for (char ch : words[j].toCharArray()) {
            cnt[ch]--;
            if (cnt[ch] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println("abac".contains("abc"));
        String[] words = {"a","b","ba","bca","bda","bdca"};
        String[] words1 = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        System.out.println(longestStrChain(words));
        System.out.println(longestStrChain(words1));

    }
}
