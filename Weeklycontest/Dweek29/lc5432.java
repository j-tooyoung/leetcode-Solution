package Dweek29;

/**
 * 5432. 去掉最低工资和最高工资后的工资平均值
 * https://leetcode-cn.com/contest/biweekly-contest-29/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class lc5432 {

    public double average(int[] salary) {
        int num = salary.length;
        double res = 0;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int val : salary) {
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
            res += val;
        }
        return (res - minVal - maxVal) / (num - 2);
    }

}
