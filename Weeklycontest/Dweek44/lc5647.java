package Dweek44;

import java.util.Arrays;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5647 {

    // 两两配对
    public int[] decode1(int[] encoded) {
        int len = encoded.length;
        int n = len + 1;
        int[] res = new int[len + 1];
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int num = 0;
        for (int i = 0; i < len; i += 2) {
            num ^= encoded[i];
        }
        res[len] = xor ^ num;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = encoded[i] ^ res[i + 1];
        }
        return res;
    }

    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int n = len+1;
        boolean[] used = new boolean[n + 1];
        int[] res = new int[len+1];
        // System.out.println(n);

        for (int i = 1; i <= n; i++) {
            used[i] = true;
            res[0] = i;
            if (dfs(encoded, used, 1, res, n)) {
                break;
            }
            used[i] = false;

        }
        return res;
    }

    private boolean dfs(int[] encoded, boolean[] used, int idx, int[] res, int n) {
        if (idx > n) {
            return false;
        }
        if (idx == n) {
            return true;
        }
        res[idx] = encoded[idx - 1] ^ res[idx - 1];
        if (res[idx] > n|| res[idx] <=0 || used[res[idx]]) {
            return false;
        }
        used[res[idx]] = true;
        if (dfs(encoded, used, idx + 1, res, n)) {
            // Arrays.stream(res).forEach(value -> System.out.print(value + " "));
            return true;
        }
        used[res[idx]] = false;

        return false;
    }
}
