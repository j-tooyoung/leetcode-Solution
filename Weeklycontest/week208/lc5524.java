package week208;

/**
 * 5524. 经营摩天轮的最大利润
 * https://leetcode-cn.com/contest/weekly-contest-208/problems/maximum-profit-of-operating-a-centennial-wheel/
 * 碰壁点1：如果你决定停止运营摩天轮，为了保证所有游客安全着陆，将免费进行所有后续轮转。这句话想表达的是：只要收了钱，停止运营摩天轮了，上面还有游客，游客的死活情况都无所谓，不需要花钱去转动摩天轮，后面会有英雄给他们转动摩天轮把他们就下来，不需要你出钱
 *
 * 碰壁点2：customers[i] 是在第 i 次轮转（下标从 0 开始）之前到达的新游客的数量。这也意味着你必须在新游客到来前轮转 i 次。这句话想表达的是：如果wait等待的人数不够4个人的时候，是个亏本生意，还要去直接做，而不能等下一波来够人再给他们上去，等价于你不能为了自己的收益，把游客全部卡住，等所有游客都来了，才把他们放上去，题目说到每一轮都必须转
 *
 * 作者：小呆呆
 * 链接：https://www.acwing.com/solution/content/21527/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class lc5524 {
    //        4 * 5 - 6
//   8*5-2*6
// 11 * 5- 18
//   [8,3]
//            5
//            6
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
// 不符合第二条
//        int sum = 0;
//        int res = Integer.MIN_VALUE;
//        int cntCustomers = 0;
//        int cntRun = 1;
//        for (int i = 0; i < customers.length; i++) {
//            sum += customers[i];
//        }
//        int ans = 0;
//        while (sum > 0) {
//            cntCustomers += Math.min(4, sum);
//            int profit = cntCustomers * boardingCost - cntRun * runningCost;
//            if (res < profit) {
//                res = profit;
//                ans = cntRun;
//            }
//            cntRun++;
//            sum -= 4;
//        }
//        return res <= 0 ? -1 : ans;

        int len = customers.length;
        int wait = 0, sum = 0, money = 0, res = 0;
        for (int i = 0; i < len || wait > 0; i++) {
            if (i <len) wait += customers[i];
            int up = Math.min(wait, 4);
            wait -= up;
            sum = sum + up * boardingCost - runningCost;
            if (sum > money) {
                money = sum;
                res = i + 1;
            }
        }
        return money <= 0 ? -1 : res;
    }

    public static void main(String[] args) {

    }
}
