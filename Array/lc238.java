import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class lc238 {

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        int r = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
            System.out.print(res[i] +", ");
        }
        System.out.println("----");
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] back = new int[len];
        res[0] = 1;
        back[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
            System.out.print(res[i] +", ");
        }
        System.out.println("----");
        for (int i = len - 2; i >= 0; i--) {
            back[i] = back[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] *= back[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
}
