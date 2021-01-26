package week225;

import java.util.*;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5663 {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        for (int i = 1; i < m; i++) {
            matrix[i][0] ^= matrix[i - 1][0];
            list.add(matrix[i][0]);
        }
        for (int i = 1; i < n; i++) {
            matrix[0][i] ^= matrix[0][i - 1];
            list.add(matrix[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] ^= matrix[i - 1][j] ^ matrix[i][j - 1] ^ matrix[i - 1][j - 1];
                list.add(matrix[i][j]);
            }
        }
        // for (int[] arr : matrix) {
        //     Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
        //     System.out.println();
        // }
        Collections.sort(list);
//         list.forEach(val -> System.out.print(val + ""));
//         System.out.println();

        return list.get(list.size() - k);
    }

}
