/**
 * 面试题 16.18. 模式匹配
 * https://leetcode-cn.com/problems/pattern-matching-lcci/
 */
public class lc16_18 {

    public static boolean patternMatching(String pattern, String value) {
        return false;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String pattern1 = "aaaa";
        String value = "dogcatcatdog";
        String value1 = "dogcatcatfish";
        String value2 = "dogdogdogdog";
        System.out.println(patternMatching(pattern, value));
        System.out.println(patternMatching(pattern, value1));
        System.out.println(patternMatching(pattern1, value));
        System.out.println(patternMatching(pattern, value2));

    }
}
