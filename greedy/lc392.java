/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class lc392 {

    // 贪心 二分 动态规划
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        //边界条件
        if (s == null ||s.length() < 1 ) return true;
        if (t == null || t.length() < 1) return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        //双指针移动
        while (i < s.length() && j < t.length()) {
            if (ch1[i] == ch2[j]) {
                i++;
                j++;
            } else {
                while (j < t.length() && ch1[i] != ch2[j]) j++;
                if (j >= t.length()) return false;
            }
        }
        if (i < s.length()) return false;
        return true;
    }

    //如果有大量输入的 S，称作S1, S2, ... , Sk
    // 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？


    public static void main(String[] args) {
        String s = "axc";
        String s1 = "acb";
        String t = "ahbgdc";
        String t1 = "ahbgdc";

        System.out.println(isSubsequence(s,t));
        System.out.println(isSubsequence(s1,t1));

    }
}
