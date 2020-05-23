import java.util.ArrayList;
import java.util.List;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class lc1371 {

    public static int findTheLongestSubstring(String s) {
        
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
                add("eleetminicoworoep");
                add("leetcodeisgreat");
                add("bcbcbc");
        }};
        for (String s : list) {
            System.out.println(s +" : " + findTheLongestSubstring(s));
        }
    }

}
