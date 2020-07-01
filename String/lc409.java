/**
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class lc409 {
    public int longestPalindrome(String s) {
        int res = 0;
        int[] cnt = new int[128];
//        for(int i = 0; i < s.length(); i++){
//            cnt[s.charAt(i) ]++;
//        }
        for (char ch : s.toCharArray()) {
            cnt[ch]++;
        }

        for(int i = 0; i < cnt.length; i++){
//            if(cnt[i] > 0) res+=(cnt[i]/2)*2;
            if(cnt[i] > 0) res += cnt[i] - (cnt[i] & 1);
        }

        return (res < s.length())? res+ 1: res;
    }

}
