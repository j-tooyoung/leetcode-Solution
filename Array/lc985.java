import java.util.HashMap;
import java.util.Map;

/**
 *  985. 查询后的偶数和
 *  https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 *
 */
public class lc985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int res = 0;
        int[] ans = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            boolean flag = (A[i] % 2 ==0);
            res += flag ? A[i] : 0;
            if(flag) map.put(i,A[i]);
        }

        for(int i = 0; i < queries.length; i++){
            if (map.containsKey(queries[i][1])) {
                if ((A[queries[i][1]] + queries[i][0]) % 2 != 0) {
                    res -= A[queries[i][1]];
                    map.remove(queries[i][1]);
                } else {
                    res += queries[i][0];
                }
                A[queries[i][1]] += queries[i][0];
            } else {
                if ((A[queries[i][1]] + queries[i][0]) % 2 == 0) {
                    res += A[queries[i][1]] + queries[i][0];
                    map.put(queries[i][1], A[queries[i][1]]);
                }
                A[queries[i][1]] += queries[i][0];
            }
            ans[i] = res;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
