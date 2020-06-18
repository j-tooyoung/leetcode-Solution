package week193;


import java.util.ArrayList;
import java.util.List;

/**
 * 5436. 一维数组的动态和
 * https://leetcode-cn.com/contest/weekly-contest-193/problems/running-sum-of-1d-array/
 */
public class lc5436 {
    public static int[] runningSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            list.add(sum);
        }
//        return list.stream().map(Integer::intValue).;
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }

}
