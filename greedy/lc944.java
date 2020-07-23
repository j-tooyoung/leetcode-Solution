/**
 * 944. 删列造序
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 *
 */
public class lc944 {

    public int minDeletionSize(String[] A) {
//        对于每一列，我们检查它是否是有序的。如果它不符合，则将答案增加 1，否则它必须被删除。


        int col = A[0].length();
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
