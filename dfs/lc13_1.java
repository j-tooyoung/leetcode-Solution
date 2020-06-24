/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class lc13_1 {

    int res = 0;
//    int[] dx = {-1, 0, 0, 1};
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        dfs(0, 0, m, n, k,vis);
        return res;
    }

    private void dfs(int i, int j, int m, int n, int k,boolean[][] vis) {
        if ( i < 0 || j < 0 || toInt(i) + toInt(j) > k || i >= m || j >= n || vis[i][j]) {
            return;
        }
        res++;
        vis[i][j] = true;
        System.out.println(i + ", " + j);
        for (int l = 0; l < 2; l++) {
            int x = i + dx[l];
            int y = j + dy[l];
            dfs(x, y, m, n, k, vis);
        }
    }

    private int toInt(int j) {
        int tmp = 0;
        while (j > 0) {
            tmp += j % 10;
            j /= 10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        lc13_1 lc13_1 = new lc13_1();
        System.out.println(lc13_1.movingCount(2, 3, 1));
        System.out.println(lc13_1.toInt(2));
    }

}
