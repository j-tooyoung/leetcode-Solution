import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * https://leetcode-cn.com/problems/shift-2d-grid/
 */
public class lc1260 {

    // 有待解决
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        int total = row * col;
        k %= (total);
        if (k == 0) {
            for (int i = 0; i < row; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < col; j++) {
                    list.add(grid[i][j]);
                }
                res.add(list);
            }
            return res;
        }
        int idx = total - k;
        int x = idx / col;
        int y = idx % col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp.add(grid[i][j]);
            }
        }
        for (int i = 0; i < row; i++) {

        }
        
        return res;
    }

}
