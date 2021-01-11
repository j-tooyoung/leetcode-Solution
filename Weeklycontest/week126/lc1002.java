package week126;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname lc1002
 * @Description
 * @Date 2021/1/11 11:28
 * @Created by j-tooyoung
 */
public class lc1002 {
    public List<String> commonChars(String[] A) {
//        Map<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        String tmp = common(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            tmp = common(A[i], tmp);
        }
        for (int i = 0; i < tmp.length(); i++) {
            res.add(String.valueOf(tmp.charAt(i)));
        }
        return res;
    }

    private String common(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            cnt2[s2.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int min = Math.min(cnt1[i], cnt2[i]);
            for (int j = 0; j < min; j++) {
                char c = (char) ('a' + i);
//                String s = String.valueOf(('a' + i));
//                System.out.println(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
