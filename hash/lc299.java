import java.util.HashMap;
import java.util.Map;

/**
 *299. 猜数字游戏
 * https://leetcode-cn.com/problems/bulls-and-cows/
 *
 */
public class lc299 {

    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int cnt1 = 0;
        int cnt2 = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                cnt1++;
            } else {
                char ch = secret.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                char ch = guess.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(ch) >= 0) {
                    cnt2++;
                }
            }
        }
        return sb.append(cnt1).append('A').append(cnt2).append('B').toString();
    }

    public static void main(String[] args) {

    }
}
