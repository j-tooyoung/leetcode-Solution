import java.util.Arrays;

/**
 * ClassName: lc4
 * Package: PACKAGE_NAME
 * Description:
 * 4. 寻找两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @date: 2020/4/8 22:50
 * @author: tooyoung
 */

public class lc4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }

    // 暴力法 排序
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            res[nums1.length + i] = nums2[i];
        }
        Arrays.sort(res);
        int right = res.length / 2;
        int left = res.length - 1 >> 1 ;
        System.out.println(left + " " + right);
        System.out.println(res[left] + " " + res[right]);
        double avg = ((res[left] + res[right]) / 2.0);
        return avg;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3,4};
        lc4 lc4 = new lc4();
        System.out.println(lc4.findMedianSortedArrays1(num1, num2));
    }
}
