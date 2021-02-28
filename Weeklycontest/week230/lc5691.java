package week230;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5691 {

    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2 * 6 || n1 * 6 < n2) {
            return -1;
        }
        // sum1 <sum2
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int diff = Math.abs(sum1 - sum2);
        int i = 0;
        int j = nums2.length - 1;
        while (diff > 0) {
            int a = i < nums1.length ? 6 - nums1[i] :0;
            int b = j >=0 ? nums2[j] - 1 :0;
            if (a > b) {
                diff -= a;
                i++;
            }else{
                diff -= b;
                j--;
            }
        }
        return i + nums2.length-1 - j;
    }

}
