/**
 * @Classname lc1319
 * @Description
 * cycle, union find
 * @Date 2021/1/23 11:03
 * @Created by j-tooyoung
 */
public class lc1319 {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        UF uf = new UF(n);
        for (int i = 0; i < len; i++) {
            uf.merge(connections[i][0], connections[i][1]);
        }
        return connections.length >= n - 1 ? uf.size() - 1 : -1;
    }

    class UF {

        private int[] pa;
        int[] rank;
        int n;
        int count;

        public UF(int n) {
            count = n;
            this.n = n;
            this.pa = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                pa[i] = i;
            }

        }

        void merge(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                if (rank[fx] < rank[fy]) {
                    int tmp = fx;
                    fx = fy;
                    fy = tmp;
                }
                pa[fy] = fx;
                rank[fx] += rank[fy];
                count--;
            }
        }

        int find(int x) {
            if (x == pa[x]) {
                return x;
            }
            pa[x] = find(pa[x]);
            return pa[x];
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        int size() {
//            for (int i = 0; i < n; i++) {
//                if (i == find(i)) {
//                    count++;
//                }
//            }
//            return count;
            return count;
        }
    }
}
