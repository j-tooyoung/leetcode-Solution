import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class lc1380 {
//    先找每行的最小值min并得到min的列坐标，再在该列中寻找有没有比min大的数，若没有则符合幸运数条件，加入列表。
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minVal = Integer.MAX_VALUE;
            int idx = 0;
            for (int j = 0; j < matrix[0].length; j++) {
//                minVal = Math.min(minVal, matrix[i][j]);
                if (matrix[i][j] < minVal) {
                    idx = j;
                    minVal = matrix[i][j];
                }
            }
            boolean flag = false;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][idx] > minVal) {
                    flag = true;
                    break;
                }
            }
            if (!flag) res.add(minVal);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
