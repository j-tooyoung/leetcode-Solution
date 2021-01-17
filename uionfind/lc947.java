/**
 * @Classname lc947
 * @Description
 * @Date 2021/1/15 20:28
 * @Created by j-tooyoung
 */
public class lc947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
//                    uf.union();
//                }
//            }
            uf.union(stones[i][0],stones[i][1] + 100000);
        }
        return n - uf.size();
    }

    class UF{
        int[] pa;
        int[] sz;
        private int n;
        public UF(int n) {
            this.n = n;
            pa = new int[n];
            sz = new int[n];
        }


        int find(int x) {
            if (x == pa[x]) {
                return x;
            }
            pa[x] = find(pa[x]);
            return pa[x];
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return;
            }
            if (sz[fx] < sz[fy]) {
                int tmp = fx;
                fx = fy;
                fy = tmp;
            }
            sz[fx] += sz[fy];
            pa[fy] = fx;
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        int size() {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (i == find(i)) {
                    cnt++;
                }
            }
            return cnt;

        }

    }

}
