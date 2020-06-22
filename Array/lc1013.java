import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1013. 将数组分成和相等的三个部分
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class lc1013 {

    public static boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            total += A[i];
        }
        if (total % 3 != 0) return false;
        int val = total / 3;
        // sum为0
        // 初始态
        int i = 1, j = len - 2;
        int firstSum = A[0], lastSum = A[len-1];
        while (i < j) {
            while (i < j && firstSum != val) firstSum += A[i++];
            while (i < j && lastSum != val) lastSum += A[j--];
            if (i < j && firstSum == lastSum && firstSum == val) return true;
        }
        return false;
    }

    public static boolean canThreePartsEqualSum1(int[] A) {
        int sum = 0;
        for(int i: A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }
        int s = 0;
        int flag = 0;
        for(int i:A){
            s += i;
            if(s == sum/3){
                flag++;
                s = 0;
            }
            if (flag == 3) {
                return true;
            }
        }
        // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
//        return flag >= 3;
        return false;
    }


    public static void main(String[] args) {
//        [10,-10,10,-10,10,-10,10,-10]
        int[] A = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] A1 = {1,-1,1,-1};
//        []
        System.out.println(canThreePartsEqualSum(A));
//        System.out.println(canThreePartsEqualSum(A1));
    }

}
