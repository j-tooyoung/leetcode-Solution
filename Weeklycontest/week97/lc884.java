package week97;

import java.util.*;

/**
 * 884. 两句话中的不常见单词
 * https://leetcode-cn.com/contest/weekly-contest-97/problems/uncommon-words-from-two-sentences/
 */
public class lc884 {

    public String[] uncommonFromSentences(String A, String B) {
//        Set<String> setA = new HashSet<>();
//        Set<String> setB = new HashSet<>();
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();

        List<String> res = new ArrayList<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String s :a) {
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }
        for (String s : b) {
            mapB.put(s, mapB.getOrDefault(s, 0) + 1);
        }
        for (String s :a) {
            if (!mapB.containsKey(s) && mapA.get(s) == 1) {
                res.add(s);
            }
        }
        for (String s : b) {
            if (!mapA.containsKey(s) && mapB.get(s) == 1) {
                res.add(s);
            }
        }
        String[] tmp = new String[res.size()];

        return res.toArray(tmp);
    }

}
