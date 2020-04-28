import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: lc3
 * Package: PACKAGE_NAME
 * Description:
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @date: 2020/4/13 10:37
 * @author: tooyoung
 */
//
public class lc3 {

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(ch, 0) + 1);
            //
            while (map.get(ch) > 1) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    //
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] index = new int[128];
        int res = 0;
//        if (s.length() == 1) return 1;
        for (int i = 0, j = 0; j < s.length(); j++) {
            // 在区间[i,j)里找到离右端点j最近的相同字符，将i始终更新为不重复区间
            i = Math.max(i, index[s.charAt(j)]);
            if (j == i) {
                res = 1;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    res = Math.max(res, j - i + 1);
                } else {
                    res = Math.max(res, j - i);
                    i = i+1;
                }
            }
            index[s.charAt(j)] = j;

            // 法2
//            i = Math.max(i, index[s.charAt(j)]);
//            res = Math.max(res, j - i + 1);
//            index[s.charAt(j)] = j + 1;   // 在区间[i,j)里找到离右端点j最近的重复字符+1的位置，将i始终更新为不重复区间
        }
        return res;
    }


    // 暴力遍历所有（i,j） 判断该区间是否为不重复，并更新res

    public static void main(String[] args) {
        lc3 lc3 = new lc3();
        String s = "au";
        String s1 = "pwwkew";

        System.out.println(lc3.lengthOfLongestSubstring2(s1));
    }
}
