/**
 * 983. 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class lc983 {

    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];

        return dp[days.length - 1];
    }
    
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int[] days1 = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs1 = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
        System.out.println(mincostTickets(days1, costs1));
    }
}
