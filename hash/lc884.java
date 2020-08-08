import java.util.*;

/**
 * 884. 两句话中的不常见单词
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */
public class lc884 {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String s : A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : B.split(" ")) {
            if (!map.containsKey(s)) {
                if (map1.get(s) <= 1) {
                    res.add(s);
                }
            }
        }
        for (String s : A.split(" ")) {
            if (!map1.containsKey(s)) {
                if (map.get(s) <= 1) {
                    res.add(s);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

}
