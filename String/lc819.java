import java.util.*;

/**
 * 819. 最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 *
 */
public class lc819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < banned.length; i++) {
            String s = banned[i].toLowerCase();
//            System.out.println(s);
            set.add(s);
        }
        paragraph = paragraph.replace(",", " ").replace(".", " ").replace("!", " ").replace("?", " ").replace(";", " ").replace("'", " ");

        paragraph = paragraph.replaceAll("\\s+", " ").trim().toLowerCase();
        String[] split = paragraph.split(" ");

        for (int i = 0; i < split.length; i++) {
            String s = split[i].toLowerCase();
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        String res = "";
        int maxCnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
