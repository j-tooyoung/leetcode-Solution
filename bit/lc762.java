import java.util.HashSet;
import java.util.Set;

/**
 * 762. 二进制表示中质数个计算置位
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class lc762 {

    public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        set.add(23);
        set.add(29);
        set.add(31);
        int ans = 0;
        for (int i = L; i <= R; i++) {
            if (set.contains(countBitOf1(i))) {
                ans++;
            }
        }
        return ans;
    }

    private int countBitOf1(int i) {
        int cnt = 0;
        while (i != 0) {
            i &= (i - 1);
            cnt++;
        }
        return cnt;
    }

}
