package week190;

/**
 * 5416. 检查单词是否为句中其他单词的前缀
 *
 * https://leetcode-cn.com/contest/weekly-contest-190/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 */
public class lc5416 {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
