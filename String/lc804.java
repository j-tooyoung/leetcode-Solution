import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
public class lc804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] s = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String st : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < st.length(); i++) {
                sb.append(s[st.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}
