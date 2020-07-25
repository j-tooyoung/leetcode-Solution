package Dweek31;

/**
 * 5457. 和为奇数的子数组数目
 * https://leetcode-cn.com/contest/biweekly-contest-31/problems/number-of-sub-arrays-with-odd-sum/
 */
public class lc5457 {

    public static int numOfSubarrays(int[] arr) {
        long res = 0;
        int mod = 1000000007;
        int len = arr.length;
        int[] pre = new int[len + 1];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + arr[i];
            boolean flag = (pre[i + 1] % 2 == 0);
            if (flag) res += odd;
            // 如果为奇数，减去之前的偶数即为，自身
            else res += even + 1;
            even = (flag == true) ? even+ 1 : even ;
            odd = (flag == true) ? odd : odd + 1;
//            res += (arr[i] % 2 == 0) ? 0 : 1;
        }
        return (int)(res % mod);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int[] arr1 = {2,4,6};
        int[] arr2 = {1,2,3,4,5,6,7};
        int[] arr3 = {100,100,99,99};
        int[] arr4 = {7};
        System.out.println(numOfSubarrays(arr));
        System.out.println(numOfSubarrays(arr1));
        System.out.println(numOfSubarrays(arr2));
        System.out.println(numOfSubarrays(arr3));
        System.out.println(numOfSubarrays(arr4));
    }

}
