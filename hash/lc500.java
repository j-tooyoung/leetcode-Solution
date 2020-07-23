import java.util.*;

/**
 * 500. 键盘行
 * https://leetcode-cn.com/problems/keyboard-row/
 */
public class lc500 {

    public String[] findWords(String[] words) {
        if (words == null) {
            return null;
        }

        List<String> ans = new ArrayList<>();

        // 字典行
        String lines[] = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        // 挨个单词匹配是否满足条件
        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }

        // 刚看到的时候有点疑惑返回值为什么不是List<String>而是String[]
        // list可直接利用API转换为String数组即可
        return ans.toArray(new String[ans.size()]);
    }

    private boolean judge(String word, String[] lines) {
        boolean ok = true;
        String find = null;

        // 先用word首字符确定属于哪一行
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                find = line;
                break;
            }
        }

        if (find == null) {
            ok = false;
            return ok;
        }

        // 判断word字符串所有字符是否都属于同一行
        for (int i = 1; i < word.length(); i++) {
            if (find.indexOf(word.charAt(i)) < 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }


    public String[] findWords1(String[] words) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        Set<Character> s3 = new HashSet<>();

        s1.add('q');
        s1.add('w');
        s1.add('e');
        s1.add('r');
        s1.add('t');
        s1.add('y');
        s1.add('u');
        s1.add('i');
        s1.add('o');
        s1.add('p');

        s2.add('a');
        s2.add('s');
        s2.add('d');
        s2.add('f');
        s2.add('g');
        s2.add('h');
        s2.add('j');
        s2.add('k');
        s2.add('l');

        s3.add('z');
        s3.add('x');
        s3.add('c');
        s3.add('v');
        s3.add('b');
        s3.add('n');
        s3.add('m');

        List<String> res = new ArrayList<>();
        List<Set> res1 = new ArrayList<>();
        String[] ans;
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i].toLowerCase();
            // System.out.println(tmp);

            char ch = tmp.charAt(0);
            boolean flag = true;
            if (s1.contains(ch)) {
                for (int j = 0; j < tmp.length(); j++) {
                    if (!s1.contains(tmp.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
            } else if (s2.contains(ch)) {
                for (int j = 0; j < tmp.length(); j++) {
                    if (!s2.contains(tmp.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < tmp.length(); j++) {
                    if (!s3.contains(tmp.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res.add(words[i]);
            }
        }
        ans = new String[res.size()];
        return res.toArray(ans);
    }
}
