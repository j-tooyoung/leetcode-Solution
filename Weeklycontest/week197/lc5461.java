package week197;

public class lc5461 {

    public static int numSub(String s) {
        long total = 0;
        int mod = 1000000007;
        int len = s.length();
        int j = 0;
        for (int i = 0; i < len; ) {
            if (s.charAt(i) == '1') {
                j = i;
                long cnt = 0;
                while (j < len && s.charAt(j) == '1') {
                    j++;
                }
                cnt = j - i;
                total += cnt * (cnt + 1) / 2;
                i = j;
            } else {
                i++;
            }
        }
        return (int) (total % mod);
    }

    public static void main(String[] args) {
        String s = "111111";
        String s1 = "111111";
        System.out.println(numSub(s));
    }
}
