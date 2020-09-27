package week208;

/**
 * 5524. 经营摩天轮的最大利润
 * https://leetcode-cn.com/contest/weekly-contest-208/problems/maximum-profit-of-operating-a-centennial-wheel/
 */
public class lc5524 {
    //        4 * 5 - 6
//   8*5-2*6
// 11 * 5- 18
//   [8,3]
//            5
//            6
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int sum = 0;
        int res = Integer.MIN_VALUE;
        int cntCustomers = 0;
        int cntRun = 1;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i];
        }
        while (sum > 0) {
            if (sum >= 4) {
                cntCustomers += 4;
                res = Math.max(res, cntCustomers * boardingCost - cntRun * runningCost);
                cntRun++;
                sum -= 4;
            } else {
                cntCustomers += sum;
                res = Math.max(res, cntCustomers * boardingCost - cntRun * runningCost);
                cntRun++;
                sum = 0;
            }
        }
        return res < 0 ? -1 : res;
    }

    public static void main(String[] args) {

    }
}
