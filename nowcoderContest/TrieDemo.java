import java.util.TreeMap;

/**
 * @Classname Trie
 * @Description
 * @Date 2021/1/30 13:03
 * @Created by j-tooyoung
 */
public class TrieDemo {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public TrieDemo() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    //向Trie中添加word
    public void addLoop(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            size++;
            cur.isWord = true;
        }
    }

    //递归的添加
    public void add(String word) {
        add(root, word, 0);
    }

    private void add(Node cur, String word, int index) {
        if (index == word.length()) {
            if (!cur.isWord) {
                size++;
                cur.isWord = true;
            }
            return;
        }
        char c = word.charAt(index);
        if (cur.next.get(c) == null) {
            cur.next.put(c, new Node());
        }
//        cur = cur.next.get(c);
        add(cur.next.get(c), word, index + 1);  // 尾递归
    }

    public boolean contains(Node cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        return cur.next.containsKey(c) && contains(cur.next.get(c), word, index + 1);
    }

// 循环版
    public boolean containsLoop(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //是否有某个前缀
    public boolean hasPrefix(String prefix) {
        return hasPrefix(root, prefix, 0);
    }

    private boolean hasPrefix(Node cur, String prefix, int index) {
        if (index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        return cur.next.containsKey(c) && hasPrefix(cur.next.get(c), prefix, index + 1);
    }

    // todo
    public boolean hasPrefixLoop(String prefix) {
        return false;
    }


}
