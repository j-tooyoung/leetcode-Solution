package week221;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc5627
 * @Description
 * @Date 2020/12/13 10:37
 * @Created by j-tooyoung
 */
public class lc5640 {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int maxVal = Integer.MIN_VALUE;
            Boolean flag = false;
            int query = queries[i][1];
            int xor = queries[i][0];
            for (int j = 0; j < nums.length; j++) {
                if (query >= nums[j]) {
                    maxVal = Math.max(maxVal, nums[j] ^xor);
                    flag = true;
                }
            }
            res[i] = flag ? maxVal : -1;

        }
        return res;
    }

    public int[] maximizeXor1(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        Map<int[], Integer> map = new HashMap<>();
        int idx = 0;
        for (int[] query : queries) {
            map.put(query, idx);
            idx++;
        }
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < queries.length; i++) {
            int maxVal = Integer.MIN_VALUE;
            Boolean flag = false;
            int query = queries[i][1];
            int xor = queries[i][0];

            for (int j = 0; j < nums.length; j++) {
                    if (query >= nums[j]) {
                        maxVal = Math.max(maxVal, nums[j] ^ xor);
                        flag = true;
                    }
                }
                res[i] = flag ? maxVal : -1;

            }
        return res;
    }

    public static void main(String[] args) {
        int num = 30;
        for (int i = 0; i < 20; i++) {
            System.out.println(num ^ i);
        }
    }

}
