package Week218;

/**
 * @Classname lc5667
 * @Description
 * @Created by j-tooyoung
 */
public class lc5620 {

    // brute force
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        String s = sb.toString();
        System.out.println(s);
        int mod = 1000_000_007;
        for (int i = 0; i < s.length(); i++) {

            ans = (ans * 10 % mod + (s.charAt(i) - '0') % mod) % mod;
            System.out.println(ans);

            ans %= mod;

        }

        return ans;
    }
}
