/**
 * 1370. 上升下降字符串
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
public class lc1370 {

    public static String sortString(String s) {
        int[] cnt = new int[26];
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int cntVal = len;
        while (cntVal != 0) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == 0) continue;
                sb.append((char) ('a' + i));
                cnt[i]--;
                cntVal--;
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] == 0) continue;
                sb.append((char) ('a' + i));
                cnt[i]--;
                cntVal--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println('z' - 'a');
        String s = "aaaabbbbcccc";
        String s1 = "rat";
        String s2 = "ggggggg";
        String s3 = "spo";
        String s4 = "leetcode";
        System.out.println('a' + 1);
        System.out.println((char) ('a' + 1));
        System.out.println(sortString(s));
        System.out.println(sortString(s1));
        System.out.println(sortString(s2));
        System.out.println(sortString(s3));
        System.out.println(sortString(s4));
    }
}
