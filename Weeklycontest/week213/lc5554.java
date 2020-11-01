package week213;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc5521
 * @Description 5554. 能否连接形成数组
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/check-array-formation-through-concatenation/
 * @Date 2020/10/25 23:44
 * @Created by j-tooyoung
 */
public class lc5554 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int len = find(i, arr, pieces);
            if (len == -1) return false;
            i += len;
        }
        return true;

    }

    private int find(int i, int[] arr, int[][] pieces) {
        for (int[] piece : pieces) {
            if (isEqual(i, arr, piece)) {
                return piece.length;
            }
        }
        return -1;
    }

    private boolean isEqual(int st, int[] arr, int[] piece) {
        for (int i = st, j = 0; i < arr.length && j < piece.length; j++, i++) {
            if (arr[i] != piece[j]) {
                return false;
            }
        }
        return true;
    }
}
