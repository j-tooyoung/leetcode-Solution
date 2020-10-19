package week211;

import java.util.HashMap;
import java.util.Map;

public class lc5543 {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
//            for (int j = 0; j < i; j++) {
//                if (s.charAt(j) == ch) {
//                    ans = Math.max(ans, i - j - 1);
//                    break;
//                }
//            }
            if (map.containsKey(ch)) {
                ans = Math.max(ans, i - map.get(ch) - 1);
            }else {
                map.put(ch, i);
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

}
