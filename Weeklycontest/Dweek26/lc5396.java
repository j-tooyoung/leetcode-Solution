package Dweek26;

public class lc5396 {
    public static int maxPower(String s) {
        int res = 1;
        for (int i = 0, j = 1; j < s.length(); j++) {
//            while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
            while (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "abbcccddddeeeeedcba";
        String s3 = "triplepillooooow";
        String s4 = "hooraaaaaaaaaaay";
        String s5 = "tourist";
        String s6 = "cc";
        System.out.println(maxPower(s1));
        System.out.println(maxPower(s2));
        System.out.println(maxPower(s3));
        System.out.println(maxPower(s4));
        System.out.println(maxPower(s5));
        System.out.println(maxPower(s6));
    }
}
