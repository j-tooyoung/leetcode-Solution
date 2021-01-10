package Dweek43;

import java.util.*;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5635 {
//
    // todo
int[] res;
    int[] cnt;

    public int[] constructDistancedSequence(int n) {
        int need = 1 + 2 * (n - 1);
        res = new int[need];
        cnt = new int[n + 1];
        Arrays.fill(cnt, 2);
        cnt[1] = 1;
        dfs(need, 0, n);
        return res;

    }

    private boolean dfs(int len, int index, int n) {
        if (index == len) {
            return true;
        }
        if (res[index] > 0) {
            // 未加return 导致返回全零数组
            return dfs(len, index + 1, n);
        }

        for (int j = n; j >= 1; j--) {
            if (cnt[j] == 0 || res[index] > 0) {
                // Arrays.stream(res).forEach(value -> System.out.print(value + " "));
                //     System.out.println();
                continue;
            }
            if (j > 1 && (j + index >= len || res[index + j] > 0)){
                continue;
            }

            // 回溯
            if (j == 1) {
                res[index] = j;
                cnt[j] = 0;
                if (dfs(len, index + 1, n)) {
                    return true;
                }
                cnt[j] = 1;
                res[index] = 0;
            } else {

                res[index] = j;
                res[index + j] = j;
                cnt[j] = 0;
                if (dfs(len, index + 1, n)) {
                    return true;
                }
                cnt[j] = 2;
                res[index] = 0;
                res[index + j] = 0;
            }

        }
        return false;

    }
}
