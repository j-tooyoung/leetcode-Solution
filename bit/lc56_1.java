/**
 * 面试题56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class lc56_1 {

    public static int[] singleNumbers(int[] nums) {
        int[] sol = new int[]{0,0};
        int res = 0;
        for(int val : nums){
            res ^= val;
        }
        int flag = 1;
        while((res & flag) == 0) flag <<= 1;
        for(int val : nums){
            if((val & flag) == 0){
                sol[0] ^= val;
            }else{
                sol[1] ^= val;
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        int[] sol = singleNumbers(nums);
        for (int val : sol) {
            System.out.print(val+",");
        }
    }
}
