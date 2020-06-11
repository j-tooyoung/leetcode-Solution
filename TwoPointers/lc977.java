import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class lc977 {

    // 双指针
    public int[] sortedSquares(int[] A) {
//        双指针可以简单点吧，从大往小取值，最大值肯定是最左和最右其中一个，且最左为正数时就不需要比较了，肯定是取最右值。
        int len = A.length;
        int[] res = new int[len];
        int left = 0;
        int right = len - 1;
        int index = len - 1;
        while (index >= 0) {
            if (A[left] < 0 && -A[left] > A[right]) {
                res[index] = A[left] * A[left];
                left++;
            } else {
                res[index] = A[right] * A[right];
                right--;
            }
            index--;
        }
        return res;
    }

    public int[] sortedSquares1(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        List<Integer> list = new ArrayList<>();
        int i;
        for (i = 0; i < len; i++) {
            if (A[i] < 0) {
                list.add(A[i] * A[i]);
            } else {
                break;
            }
        }
        int j = list.size() - 1;
        int idx = 0;
        while (i < len && j >= 0) {
            if (A[i] * A[i] < list.get(j)) {
                res[idx++] = A[i] * A[i];
                i++;
            } else {
                res[idx++] = list.get(j);
                j--;
            }
        }
        while (i < len) {
            res[idx++] = A[i] * A[i];
            i++;
        }
        while (j >= 0) res[idx++] = list.get(j--);
        return A;
    }

    //暴力
    public int[] sortedSquares2(int[] A) {
        int len = A.length;
//        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
