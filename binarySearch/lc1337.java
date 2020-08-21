import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1337. 方阵中战斗力最弱的 K 行
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 * 自定义排序
 * 升序排序,则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
 */
public class lc1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
//        int[] cnt = new int[row];
        int[] res = new int[k];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int cnt = 0;
            for (int j = 0; j < col; j++) {
                cnt = (mat[i][j] == 1) ? ++cnt : cnt;
            }
            list.add(new int[]{i, cnt});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[1] < t2[1]) {
                    return -1;
                } else if (t1[1] == t2[1]) {
                    return t1[0] - t2[0];
                }
                return 1;
            }
        });
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
