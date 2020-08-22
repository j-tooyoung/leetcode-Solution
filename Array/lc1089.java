import java.util.Arrays;

/**
 * 1089. 复写零
 * https://leetcode-cn.com/problems/duplicate-zeros/
 */
public class lc1089 {


    // 有待满足题目条件
    public static void duplicateZeros(int[] arr) {
        int len = arr.length;

        int[] newArr = Arrays.copyOf(arr, len);
        int i = 0;
        for (int k = 0; i < len && k < len; k++) {
            if (newArr[k] == 0) {
                if (i + 1 < len) {
                    arr[i] = 0;
                    arr[i + 1] = 0;
                } else {
                    arr[i] = newArr[k];
                }
                i += 2;
            } else {
                arr[i++] = newArr[k];
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,0,2,3,0,4,5,0};
//        int[] arr1 = {1,0,2,3,0,4,5,0};
//        int[] arr3 = {0,1,7,6,0,2,0,7};
        int[] arr2 = {8,4,5,0,0,0,0,7};
        int[] arr4 = {0,1,7,6,0,2,0,7};
        duplicateZeros(arr4);
        for (int val : arr4) {
            System.out.println(val);
        }
    }

}
