import java.util.HashSet;
import java.util.Set;

/**
 * 1189. “气球” 的最大数量
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 *
 */
public class lc1189 {

    public static int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        String s = "balloon";
        int[] cnt2 = new int[26];
        int res = Integer.MAX_VALUE;
        int len = text.length();
        for (int i = 0; i < len; i++) {
            cnt[text.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            cnt2[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < cnt2.length; i++) {
            if (cnt2[i] > 0) {
                if (cnt[i] < cnt2[i]) {
                    return 0;
                }
                res = Math.min(res, cnt[i] / cnt2[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        String text1 = "leetcode";
        String text2 = "nlaebolko";
        String text3 = "lloo";
        String text4 = "balon";
        String text5 = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons(text));
        System.out.println(maxNumberOfBalloons(text1));
        System.out.println(maxNumberOfBalloons(text2));
        System.out.println(maxNumberOfBalloons(text3));
        System.out.println(maxNumberOfBalloons(text4));
        System.out.println(maxNumberOfBalloons(text5));
    }
}
