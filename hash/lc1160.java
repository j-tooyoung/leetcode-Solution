/**
 * 1160. 拼写单词
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class lc1160 {
    public static int countCharacters(String[] words, String chars) {
        int[] cnt = new int[27];
        int res = 0;
        for (int i = 0; i < chars.length(); i++) {
            cnt[chars.charAt(i) - '0']++;
        }
        for (String s : words) {
            int[] cnt2 = new int[27];
//            cnt2 = cnt;
            System.arraycopy(cnt, 0, cnt2, 0, 27);
            char[] ch = s.toCharArray();
            boolean flag = true;
            for (int i = 0; i < ch.length; i++) {
                cnt2[ch[i] - '0']--;
                if (cnt2[ch[i] - '0'] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) res+= ch.length;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
