package Week220;

import java.util.*;

/**
 * @Classname lc5627
 * @Description
 * @Date 2020/12/13 10:37
 * @Created by j-tooyoung
 */
public class lc5632 {

    // https://leetcode-cn.com/problems/checking-existence-of-edge-length-limited-paths/solution/jian-cha-bian-chang-du-xian-zhi-de-lu-ji-c756/
    // queries 按照 limit从小到大进行排序，这样所有的询问中对边权的限制就单调递增了。
    // 同时，我们将 edgeList  按照
    //  从小到大进行排序，这样所有的边权也就单调递增了。

    //《算法四》路径压缩带权重并查集模板
    // true answer
    static class Union {
        int[] id;
        int[] sz;

        public Union(int n) {
            this.id = new int[n];
            this.sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public void union(int i, int j) {
            int fi = root(i);
            int fj = root(j);
            if (fi == fj) {
                return;
            }
            if (sz[fi] > sz[fj]) {
                sz[fi] += sz[fj];
                id[fj] = fi;
            } else {
                sz[fj] += sz[fi];
                id[fi] = fj;
            }
        }

        //        public int root(int i) {
//            return id[i] == i ? i : root(id[i]);
//        }
        public int root(int i) {
            while (id[i] != i) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean connect(int i, int j) {
            return root(i) == root(j);
        }
    }

    //参考大佬的思想，边长排序，将小于查询边长的节点全部连接，然后只需要判断要查询的节点连不连通，真滴秀
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Union union = new Union(n);
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        int size = queries.length;
        boolean[] res = new boolean[size];
        int i = 0;
        Map<int[], Integer> map = new HashMap<>();
        for (int[] q : queries) {
            map.put(q, i++);
        }
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        int index = 0;
        for (int[] arr : queries) {
            while (index < edgeList.length && edgeList[index][2] < arr[2]) {
                union.union(edgeList[index][0], edgeList[index][1]);
                ++index;
            }
            res[map.get(arr)] = union.connect(arr[0], arr[1]);
        }
        return res;
    }

    // fixme error
    public boolean[] distanceLimitedPathsExist1(int n, int[][] edgeList, int[][] queries) {
        int size = queries.length;
        UF uf = new UF(n);
        boolean[] res = new boolean[size];
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Map<int[], Integer> map = new HashMap<>();
        int i = 0;
        for (int[] query : queries) {
            map.put(query, i++);
        }
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        int index = 0;
        for (int[] query : queries) {
            while (index < edgeList.length && edgeList[index][2] < query[2]) {
                uf.union(edgeList[index][1], edgeList[index][0]);
                index++;
            }
            res[map.get(query)] = uf.connected(query[0], query[1]);
        }
//        Arrays.sort(edgeList, (a, b) -> {
//            return a[2] - b[2];
//        });
//        Arrays.sort(queries, (a,b) -> {
//            return a[2] - b[2];
//        });
        return res;
    }

}


class UF {
    int[] fa;
    int[] sz;

    public UF(int n) {
        fa = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            sz[i] = 1;
        }
    }

    int find(int x) {
        while (x != find(x)) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;

//        if (fa[x] == x) {
//            return x;
//        }
//        fa[x] = find(fa[x]);
//        return fa[x];
    }

    void union(int x, int y) {
        int fx = fa[x];
        int fy = fa[y];
        if (fx == fy) {
            return ;
        } else if (sz[x] < sz[y]) {
            fa[x] = fy;
            sz[y] += sz[x];
        } else {
            fa[y] = fx;
            sz[x] += sz[y];
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
