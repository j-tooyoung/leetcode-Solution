package week198;

/**
 * 5464. 换酒问题
 * https://leetcode-cn.com/contest/weekly-contest-198/problems/water-bottles/
 */
public class lc5464 {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottoles = 0;
        int res = numBottles;
        // 将酒喝掉变成空瓶子，每轮循环更新空瓶子和酒瓶子数
        while (emptyBottoles+numBottles >= numExchange) {
            emptyBottoles += numBottles ;
            numBottles = emptyBottoles / numExchange;
            emptyBottoles %= numExchange ;
            res += numBottles;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(5, 5));
        System.out.println(numWaterBottles(2, 3));
    }


}
