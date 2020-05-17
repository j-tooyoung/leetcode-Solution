package week188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5405. 形成两个异或相等数组的三元组数目
 * https://leetcode-cn.com/contest/weekly-contest-188/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class lc5405 {
    public static int countTriplets(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = i+ 1 ; k < arr.length; k++) {

                List<Integer> res = new ArrayList<>();
                for (int tmp = i + 1; tmp <= k; tmp++) {
                    int a = 0;
                    int b = 0;
                    for (int j = i; j < tmp; j++) {
                        a ^= arr[j];
                    }
                    for (int j = tmp; j <= k; j++) {
                        b ^= arr[j];
                    }
                    if (a == b) {
//                        System.out.println(i + "," + tmp + "," + k);
                        cnt++;
//                        break;
                    }
                }
            }
        }
        return cnt;
    }

    //
    public static int countTriplets1(int[] arr) {
        int cnt = 0;
        int[] num = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            num[i + 1] = num[i] ^ arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k <= arr.length; k++) {
                for (int tmp = i + 1; tmp < k; tmp++) {
                    if ((num[i] ^ num[tmp]) == (num[tmp ] ^ num[k])) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {2, 3};
        int[] arr3 = {1,3,5,7,9};
        int[] arr4 = {7,11,12,9,5,2,7,17,22};
//        System.out.println(0 ^ 1);
//        System.out.println(countTriplets(arr));
//        System.out.println(countTriplets(arr1));
//        System.out.println(countTriplets(arr2));
//        System.out.println(countTriplets(arr3));
//        System.out.println(countTriplets(arr4));
        System.out.println(countTriplets1(arr));
        System.out.println(countTriplets1(arr1));
        System.out.println(countTriplets1(arr2));
        System.out.println(countTriplets1(arr3));
        System.out.println(countTriplets1(arr4));
    }

    public int[] subSort(int[] array) {
        if(array == null || array.length < 1) return new int[]{-1,-1};
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while(i <arr.length && arr[i] == array[i]) i++;
        while(j >= 0 && arr[j] == array[j]) j--;
        return i > j ?new int[]{-1,-1} : new int[]{i,j};
    }
}
