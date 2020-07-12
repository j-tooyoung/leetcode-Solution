import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class lc1002 {

    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A.length == 1) return Arrays.asList(A);
        String common = commonChars(A[0], A[1]);
        int len = A.length;
        for (int i = 1; i < len; i++) {
            common = commonChars(common, A[i]);
            if (common.length() < 1) {return res;}
        }
        for (char ch : common.toCharArray()) {
            res.add(String.valueOf(ch));
        }
        return res;
    }

    private static String commonChars(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s1.toCharArray()) {
            System.out.println(c - 'a');
            cnt1[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > 0 && cnt2[i] > 0) {
                int cnt = Math.min(cnt1[i], cnt2[i]);
                for (int j = 0; j < cnt; j++) {
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println('c' - 'a');
        System.out.println((char) ('a' + 1));
        String s = "[\"bella\",\"label\",\"roller\"]";
        StringArr_Factory stringArr_factory = new StringArr_Factory();
        System.out.println(Arrays.toString(stringArr_factory.produce(s)));
    }
}
