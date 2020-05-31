package week191;

/**
 * 5426. 重新规划路线
 * https://leetcode-cn.com/contest/weekly-contest-191/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
public class lc5426 {

    // 有问题
    public static int minReorder(int n, int[][] connections) {
        UF uf = new UF(n);
        int[] f = uf.f;
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        int res = 0;
        for (int i = 0; i < connections.length; i++) {
            if (uf.find(connections[i][0]) == 0) {
                res++;
                swap(connections[i][0], connections[i][1]);
            }
            uf.union(connections[i][0], connections[i][1]);
        }
        return res;
    }

    private static void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }


    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(6, connections));

    }

}

class UF {

    int n;
    public int[] f;

    public UF(int n) {
        f = new int[n];
    }

    int find(int x) {
        while (f[x] != x) {
            x = f[x];
        }
        return f[x];
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f[x] = y;
        }
    }
}
