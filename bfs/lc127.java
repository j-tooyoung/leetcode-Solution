import java.util.*;

/**
 * ClassName: lc127
 * Package: PACKAGE_NAME
 * Description:
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 * @date: 2020/4/8 22:46
 * @author: tooyoung
 */

public class lc127 {

    // 单词转换判断的优化 (23ms)
    //判断当前单词可以转换成哪些候选单词（未访问的单词），有两种思路：
    //
    //思路1：遍历所有候选单词，判断当前单词是否可以转换成这个候选单词。判断的过程也就是前面的canConvert方法，逐个对比单词的字符。
    //
    //思路2：因为单词是由 a~z 这有限数量的字符组成的，可以遍历当前单词能转换成的所有单词，判断其是否包含在候选单词中。候选单词用 HashSet 保存，可以大大提高判断包含关系的性能。
    //
    //作者：jzj1993
    //链接：https://leetcode-cn.com/problems/word-ladder/solution/suan-fa-shi-xian-he-you-hua-javashuang-xiang-bfs23/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        // 从两端 BFS 遍历要用的队列
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> beginVis = new HashSet<>();
        Set<String> endVis = new HashSet<>();
        q1.offer(beginWord);
        q2.offer(endWord);
        beginVis.add(beginWord);
        endVis.add(endWord);

        int cnt = 1;
        Set<String> allWordSet = new HashSet<>(wordList);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            if (q1.size() > q2.size()) {
                Queue<String> tmp = q1;
                q1 = q2;
                q2 = tmp;

                Set<String> set = beginVis;
                beginVis = endVis;
                endVis = set;
            }
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                String s = q1.poll();
                char[] ch = s.toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    char tmp = ch[j];
                    // 将第j位修改
                    for (char k = 'a'; k <= 'z'; k++) {
                        ch[j] = k;
                        String s1 = new String(ch);
                        if (beginVis.contains(s1)) {
                            continue;
                        }
                        if (!allWordSet.contains(s1)) {
                            continue;
                        }
                        if (endVis.contains(s1)) {
                            return cnt + 1;
                        } else {
                            beginVis.add(s1);
                            q1.add(s1);
                        }
                    }
                    ch[j] = tmp;
                }
            }
            cnt++;
        }
        return 0;
    }

        // 双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        int start = wordList.size() - 1;
        int end = wordList.indexOf(endWord);
        // 从两端 BFS 遍历要用的队列
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<Integer> beginVis = new HashSet<>();
        Set<Integer> endVis = new HashSet<>();
        q1.add(start);
        q2.add(end);
        beginVis.add(start);
        endVis.add(end);
        int cnt = 1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            cnt++;
            if (q1.size() > q2.size()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                Set<Integer> set = beginVis;
                beginVis = endVis;
                endVis = set;
            }
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                String s = wordList.get(q1.poll());
                for (int j = 0; j < wordList.size(); j++) {
                    if (beginVis.contains(j)) {
                        continue;
                    }
                    if (isValid(s, wordList.get(j))) {
                        if (endVis.contains(j)) {
                            return cnt;
                        }
                        beginVis.add(j);
                        q1.add(j);
                    }
                }
            }
        }
        return 0;
    }

    // 单向bfs
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
//        Set<String> set = new HashSet<>();
        // visited 修改为 boolean 数组
        boolean[] visited = new boolean[wordList.size()];

        int cnt = 1;
        while (!q.isEmpty()) {
            // 求bfs最短路径
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();

                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && isValid(s, wordList.get(j))) {
                        if (s.equals(endWord)) {
                            return cnt + 1;
                        }
                        q.add(wordList.get(j));
                        visited[j] = true;
                    }
                }
                for (String s1 : wordList) {
//                    if (!set.contains(s1) && isValid(s, s1)) {
//                        q.add(s1);
//                        set.add(s1);
//                    }
                }
            }
            cnt++;
        }
        return 0;
    }

    private boolean isValid(String s, String s1) {
        int cnt = 0;
        if (s.length() != s1.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s1.charAt(i)) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {

    }

}
