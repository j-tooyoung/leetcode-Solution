package week184;

import java.util.*;

/**
 * @Classname lc1408
 * @Description
 * @Date 2021/1/16 14:01
 * @Created by j-tooyoung
 */
public class lc1408 {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
//        Arrays.stream(words).forEach(val -> System.out.print(val+" "));

        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    // trie模板
    public List<String> stringMatching1(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
//        Arrays.stream(words).forEach(val -> System.out.print(val+" "));

        List<String> res = new ArrayList<>();
        root = new TrieNode();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                int idx = find(ch, j);
                if (idx != j) {
                    set.add(new String(ch, j, idx - j));
                }
            }
            add(ch);
        }
        return new ArrayList<>(set);
    }

    private int find(char[] ch, int idx) {
        TrieNode node = root;
        TrieNode next;
        int i = idx;
        while (i < ch.length) {
            next = node.child[ch[i] - 'a'];
            if (next == null) {
                break;
            }
            node = next;
            i++;
        }
        if (node.tail) {
            return i;
        }
        return idx;
    }

    private void add(char[] ch) {
        TrieNode node = root;
        for (char c : ch) {
            node = node.add(c - 'a');
        }
    }

    TrieNode root;

    class TrieNode{
        boolean tail = true;
        TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
        }

        public TrieNode add(int c) {
            tail = false;
            if (child[c] == null) {
                child[c] = new TrieNode();
            }
            return child[c];
        }
    }
}
