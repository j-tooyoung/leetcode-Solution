/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 题解
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 */
public class lc14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) return strs[0];
        String res = CommonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            res = CommonPrefix(res, strs[i]);
            //优化
            if (res.length() < 1) return res;
        }
        return res;
    }

    private static String CommonPrefix(String s1, String s2) {
        int m = 0;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        while (m < ch1.length && m < ch2.length) {
            if (ch1[m] != ch2[m]) {
                break;
            } else {
                m++;
            }
        }
        return s1.substring(0, m);
    }

    public static void main(String[] args) {
        String[] list = {"flower", "flow", "flight"};
        String[] list1 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(list));
        System.out.println(longestCommonPrefix(list1));
    }


}
