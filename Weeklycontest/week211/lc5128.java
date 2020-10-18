package week211;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 并查集
public class lc5128 {

    int[] parent;
    int[] sz;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        parent = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        //
        Set<Integer> set = new HashSet<>();
        for (int i = threshold + 1; i <= n; i++) {
            if (set.contains(i)) continue;

            for (int j = i + i; j <= n; j += i) {
                union(i, j);
                set.add(j);
//                int gcd = gcd(i, j);
//                for (int k = 1; k * gcd <= j; k++) {
//                    int target = k * gcd;
//                    if (j % target == 0 && i % target == 0 && target > threshold) {
//                        union(i, j);
//                    }
//                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (find(queries[i][0]) == find(queries[i][1])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) {
            return;
        }
        if (sz[fx] < sz[fy]) {
            parent[fx] = fy;
            sz[fy] += sz[fx];
        } else {
            parent[fy] = fx;
            sz[fx] += sz[fy];
        }
    }

    int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
        //  爆stack
//        if (x == find(x)) {   // 错误
//        if (x == parent[x]) {
//            return x;
//        } else {
//            //
//            parent[x] = find(parent[x]);
//            return parent[x];
//        }
    }


    public static void main(String[] args) {
        lc5128 lc5128 = new lc5128();
        System.out.println(lc5128.gcd(4, 8));
    }
}
