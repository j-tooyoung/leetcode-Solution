package week106;

/**
 * @Classname lc922
 * @Description
 * @Date 2021/1/2 15:41
 * @Created by j-tooyoung
 */
public class lc922 {

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        int len = A.length;
        while (i < len && j < len) {
            if (A[i] % 2 == 0 && A[j] % 2 == 1) {
                i += 2;
                j += 2;
                continue;
            } else if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i += 2;
                j += 2;
            } else if (A[i] % 2 == 1 && A[j] % 2 == 1) {
                j += 2;
            } else if (A[i] % 2 == 0 && A[j] % 2 == 0) {
                i += 2;
            }
        }
        return A;
    }

}
