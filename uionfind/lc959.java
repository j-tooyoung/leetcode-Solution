/**
 * @Classname lc995
 * @Description
 * @Date 2021/1/25 17:26
 * @Created by j-tooyoung
 */
public class lc959 {


    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        uf u = new uf(n * n * 4);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = 4 * ((i * n) + j);
                if (grid[i].charAt(j) == '/') {
                    u.merge(idx, idx + 3);
                    u.merge(idx + 1, idx + 2);
                } else if (grid[i].charAt(j) == ' ') {
                    u.merge(idx, idx + 1);
                    u.merge(idx, idx + 2);
                    u.merge(idx, idx + 3);
                }else {
                    u.merge(idx, idx + 1);
                    u.merge(idx + 3, idx + 2);
                }
                if (j < n - 1) {
                    u.merge(idx + 1, idx + 7);
                }
                if (i < n - 1) {
                    u.merge(idx + 2, idx+4*n);
                }
            }
        }
        return u.size();
    }

    class uf{
        private int[] fa;
        private int[] rank;
        private int n;
        private int count;


        public uf(int n) {
            this.n = n;
            this.count = n;
            fa = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x){
            if (x == fa[x]) {
                return x;
            }
            fa[x] = find(fa[x]);
            return fa[x];
        }

        void merge(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                if (rank[fy] > rank[fx]) {
                    int tmp = fx;
                    fx = fy;
                    fy = tmp;
                }
                count--;
                fa[fy] = fx;
                rank[fx] += rank[fy];
            }
        }

        int size() {
            return count;
        }

    }

}
