package Week222;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5642 {

    public int countPairs(int[] deliciousness) {
        int mod = 1000_000_007;
        int res = 0;
        int len = deliciousness.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                int sum = deliciousness[i] + deliciousness[j];
//                if (Integer.bitCount(sum) == 1) {
//                    res++;
//                }
//            }
//        }
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(deliciousness);

        for (int i = 0; i < len; i++) {
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
            for (int j = 0; j < 31; j++) {
                int target = (1 << j);
                System.out.println(target);
                if (map.containsKey(target - deliciousness[i])) {
                    if (target == 2 * deliciousness[i]) {
                        int cnt = map.get(target - deliciousness[i]);
                        res += cnt - 1;
                    } else {
                        res += map.get(target - deliciousness[i]);
                    }
                    res %= mod;
                }
            }

        }
        return res;
    }

    public int countPairs1(int[] deliciousness) {
        int mod = 1000_000_007;
        int res = 0;
        int len = deliciousness.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = deliciousness[i];
            for (int j = 0; j <= 22; j++) {
                int target = (1 << j) - num;
                if (map.containsKey(target)) {
                    res += map.get(target);
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            res %= mod;
        }
        return res;
    }

}
