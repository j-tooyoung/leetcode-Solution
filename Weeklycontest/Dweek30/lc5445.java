package Dweek30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class lc5445 {

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int len = n * (n + 1) / 2;
//        int[] arr = new int[len];
        int[] arr1 = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr1[i + 1] = arr1[i] + nums[i];
//            System.out.println(nums[i] +"," + arr1[i + 1]);
           if (i > 0)list.add(nums[i]);
            list.add(arr1[i + 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 2; j <= n; j++) {
                list.add(arr1[j] - arr1[i]);
//            System.out.println(arr1[j] - arr1[i]);
            }
        }
        Collections.sort(list);
//        for (int val : list) {
//            System.out.println(val);
//        }
        long sum = 0;
        int mod = 1000000007;
        for (int i = left; i <= right; i++) {
//            System.out.println(list.get(i - 1));
            sum += list.get(i - 1);
        }
        return (int) (sum % mod);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums1 = {7, 5, 8, 5, 6, 4, 3, 3};
        System.out.println(rangeSum(nums, 4, 1, 5));
        System.out.println(rangeSum(nums1, 8, 2, 6));
    }
}
