package Dweek26;

//https://leetcode-cn.com/contest/biweekly-contest-26/problems/form-largest-integer-with-digits-that-add-up-to-target/
public class lc5399 {


    public static String largestNumber(int[] cost, int target) {
        String res = "a";
        
        return res;
    }

    public static void main(String[] args) {
        int[] cost = {4,3,2,5,6,7,2,5,5};
        int[] cost1 = {4,3,2,5,6,7,2,5,5};
        int[] cost2 = {4,3,2,5,6,7,2,5,5};
        int[] cost3 = {6, 10, 15, 40, 40, 40, 40, 40, 40};
        int target = 9;
        int target1 = 12;
        int target2 = 5;
        int target3 = 47;
        System.out.println(largestNumber(cost, target));
        System.out.println(largestNumber(cost1, target1));
        System.out.println(largestNumber(cost2, target2));

    }
}
