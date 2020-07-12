/**
 * 1475. 商品折扣后的最终价格
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class lc1475 {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] = prices[i] - prices[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) res[i] =  prices[i];
        }
        return res;
    }

}
