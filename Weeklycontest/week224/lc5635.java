package week224;

import java.util.*;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5635 {

    public int[] constructDistancedSequence(int n) {
        int need = 1 + 2 * (n - 1);
        int[] res = new int[need];
        List<int[]> path = new ArrayList<>();
        int[] cnt = new int[n + 1];
        Arrays.fill(cnt, 2);
        cnt[0] = 1;
        dfs(res, need, 0, n, cnt, path);
        Collections.sort(path, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    if (o1[i] < o2[i]) {
                        return -1;
                    } else if (o1[i] > o2[i]) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        System.out.println(path.size());

        return path.get(0);

    }

    private boolean dfs(int[] res, int len, int index, int n, int[] cnt, List<int[]> path) {
        if (index == len) {

            return true;
        }
        if (res[index] != 0) {
            return true;
        }

        for (int j = n; j >= 1; j--) {

            if (cnt[j] == 0 || res[index] > 0) {
                continue;
            }
            if (index + j < len && res[index + j] > 0) {
                continue;
            }

            // 回溯 todo
            if (j == 1) {
                res[index] = j;
                cnt[j] = 0;
                if (dfs(res, len, index + 1, n, cnt, path)) {
                    return true;
                }
                cnt[j] = 1;
                res[index] = 0;
            } else if ( j + index < len) {
                res[index] = j;
                res[index + j] = j;
                cnt[j] = 0;
                if (dfs(res, len, index + 1, n, cnt, path)) {
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
