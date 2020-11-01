package Dweek38;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Classname lc5547
 * @Description
 * 5542. 通过给定词典构造目标字符串的方案数
 * https://leetcode-cn.com/contest/biweekly-contest-38/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 * @Date 2020/10/18 20:13
 * @Created by j-tooyoung
 */
public class lc5542 {

    // todo
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words.length;
        int len = words[0].length();
        int[][] dp = new int[len + 1][len + 1];
        int mod = (int) (1e9 + 7);
        int[][] cnt = new int[26][len];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                cnt[words[i].charAt(j) - 'a'][j]++;
            }
        }

        //初始化
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= len; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1] * cnt[target.charAt(i - 1) - 'a'][j - 1]) % mod;
            }
        }
        return dp[m][len];
    }

    public int numWays1(String[] words, String target) {
        int len = target.length();
        int wordLen = words.length;
        int lengthOfword = words[0].length();

        long[][] dp = new long[len + 1][lengthOfword +1];
        int mod = (int) (1e9+7);
        Map<pair, Integer> map = new HashMap<>();

        for (int i = 0; i < wordLen; i++) {
            for (int j = 0; j < lengthOfword; j++) {
                pair pair = new pair(words[i].charAt(j), j);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }
        map.forEach((key,val) -> System.out.println(key + " " + val));
        // System.out.println(map.get(new pair(words[0].charAt(0), 0)));

        //初始化
        for (int i = 0; i <= lengthOfword; i++) {
            dp[0][i] = 1;
        }
        // 构建target第i个字符，用到words第j个的方案数
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= lengthOfword; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] * map.getOrDefault(new pair(target.charAt(i-1), j-1), 0);
            }

        }
//        for (long[] longs : dp) {
//            for (long aLong : longs) {
//                System.out.print(aLong + " ");
//            }
//            System.out.println();
//        }
        return (int) (dp[len][lengthOfword] % mod);

    }

    class pair{
        char ch;
        int idx;

        @Override
        public String toString() {
            return "pair{" +
                    "ch=" + ch +
                    ", idx=" + idx +
                    '}';
        }

        public pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            pair pair = (pair) o;

            if (ch != pair.ch) return false;
            return idx == pair.idx;
        }

        @Override
        public int hashCode() {
            int result = ch;
            result = 31 * result + idx;
            return result;
        }
    }

}
