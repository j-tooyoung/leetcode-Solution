package week150;

/**
 * @Classname lc1160
 * @Description
 * @Date 2021/1/12 18:15
 * @Created by j-tooyoung
 */
public class lc1160 {

    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        int[] cnt2 ;
        for (int i = 0; i < chars.length(); i++) {
            cnt[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            cnt2 = new int[26];
            for (int j = 0; j < len; j++) {
                cnt2[words[i].charAt(j) - 'a']++;
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (cnt2[j] > cnt[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
//                System.out.println(len + " " + words[i]);
                res += len;
            }
        }
        return res;
    }
}
