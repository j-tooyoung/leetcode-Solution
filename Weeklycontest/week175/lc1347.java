package week175;

/**
 * @Classname lc1347
 * @Description
 * @Date 2021/1/2 15:35
 * @Created by j-tooyoung
 */
public class lc1347 {

    public int minSteps(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            res += (cnt1[i] > cnt2[i]) ? cnt1[i] - cnt2[i] : 0;
        }
        return res;
    }
}
