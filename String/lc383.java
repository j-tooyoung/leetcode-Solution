/**
 * 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class lc383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int ch = ransomNote.charAt(i) - 'a';
            cnt[ch]--;
            if (cnt[ch] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
