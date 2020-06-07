/**
 * 896. 单调数列
 * https://leetcode-cn.com/problems/monotonic-array/
 */
public class lc896 {

    public static boolean isMonotonic(int[] A) {
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                flag1 = false;
                break;
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                flag2 = false;
                break;
            }
        }
        return flag1 || flag2;
    }


    /**
     * 要在一次遍历中执行该检查，我们将会处理由 \{-1, 0, 1\}{−1,0,1} 组成的比较流，分别对应 <，==，或 >。例如，对于数组 [1, 2, 2, 3, 0]，我们将会看到数据流 (-1, 0, -1, 1)。
     *
     * 算法
     *
     * 跟踪 store，它的值等于所看到的第一个非零比较值（如果存在）。一旦我们看到与之相反的比较值，那么答案就变成了 False。
     *
     * 否则，每次比较值都必定在集合 \{-1, 0\}{−1,0} 中或是在 \{0, 1\}{0,1} 中，此时数组是单调的。
     *
     * @param A
     * @return
     */
    public static boolean isMonotonic1(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int c = Integer.compare(A[i], A[i + 1]);
            if (c != 0) {
                if (res != 0 && c != res) {
                    return false;
                }
                res = c;
            }
        }
        return true;


    }

    public static void main(String[] args) {

    }
}
