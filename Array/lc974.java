import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 974. 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class lc974 {

    // (a - b) mod k == 0
    // a mod k == b mod k
    public static int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //需要对哈希表初始化，记录 \textit{record}[0] = 1record[0]=1，这样就考虑了前缀和本身被 K整除的情况
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum += A[i];
            int same = (sum % K + K) % K;
            int cnt = map.getOrDefault(same, 0);
            res += cnt;
            map.put(same, cnt + 1);
        }
        return res;
    }

    // 暴力法 超时
    public static int subarraysDivByK1(int[] A, int K) {
        int len = A.length;
        int res = 0;
        int[] nums = new int[len + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= len; i++) {
            nums[i] = nums[i - 1] + A[i - 1];
            System.out.println(i + " -> " + nums[i]);
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = nums[i] - nums[j];
                if (set.contains(tmp)) {
                    res++;
                } else if (tmp % K == 0) {
                    res++;
                    set.add(tmp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK(A, 5));
    }

}
