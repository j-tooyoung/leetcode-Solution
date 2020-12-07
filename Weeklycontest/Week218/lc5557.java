package Week218;

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
}
