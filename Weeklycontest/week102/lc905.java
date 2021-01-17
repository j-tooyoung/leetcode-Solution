package week102;

/**
 * @Classname lc905
 * @Description
 * @Date 2021/1/14 11:02
 * @Created by j-tooyoung
 */
public class lc905 {
    public int[] sortArrayByParity(int[] A) {
        if (A.length < 1) return A;
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            while (i < j && A[j] % 2 == 1) {
                j--;
            }
            if (i < j) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
        }
        return A;
//        while (j < A.length) {
//            if (A[i] % 2 == 0) {
//                i++;
//            } else {
//
//            }
//        }
//        return null;
    }
}
