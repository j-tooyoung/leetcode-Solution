package week184;

import java.util.Arrays;

/**
 * @Classname lc1409
 * @Description
 * @Date 2021/1/16 14:09
 * @Created by j-tooyoung
 */
public class lc1409 {

    // 暴力法
    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        int[] res = new int[len];
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        int[] tmp = new int[m];
        for (int i = 0; i < len; i++) {
            int query = queries[i];
            int idx = find(p, query);
            res[i] = idx;

            System.arraycopy(p, 0, tmp, 0, m);
            if (idx == 0) {
                continue;
            }
            p[0] = tmp[idx];
            int k = 0;
            for (int j = 1; j < m; j++) {
                if (j == idx) {
                    k++;
                }
                p[j] = tmp[k++];
            }
//            Arrays.stream(p).forEach(value -> System.out.print(value + " "));
//            System.out.println();

        }
        return res;
    }

    private int find(int[] p, int query) {
        for (int i = 0; i < p.length; i++) {
            if (query == p[i]) {
                return i;
            }
        }
        return 0;
    }

}
