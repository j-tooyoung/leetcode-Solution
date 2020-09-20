package week206;

/**
 * @Classname lc5022
 * @Description TODO
 * @Date 2020/9/13 9:56
 * @Created by xp123
 * 5511. 二进制矩阵中的特殊位置
 * https://leetcode-cn.com/contest/weekly-contest-206/problems/special-positions-in-a-binary-matrix/
 */
public class lc5511 {

    public static int numSpecial(int[][] mat) {
        int res = 0;
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    continue;
                } else {
                    if (i > 0 && mat[0][j] == 1)break;
                    boolean flag = false;
                    int x = i, y = j;
                    for (int k = 0; k < col; k++) {
                        if (k == y) continue;
                        if (mat[x][k] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    for (int k = 0; k < row; k++) {
                        if (k == x) continue;
                        if (mat[k][y] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    mat[0][y] = 1;
                    System.out.println(i + " " + j);
                    if (!flag) res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] mat= [[1,0,0],
//            [0,0,1],
//            [1,0,0]];
        System.out.println();
    }
}
