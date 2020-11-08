package week214;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname lc5563
 * @Description 5563. 销售价值减少的颜色球
 * https://leetcode-cn.com/contest/weekly-contest-214/problems/sell-diminishing-valued-colored-balls/
 * @Date 2020/11/8 10:43
 * @Created by j-tooyoung
 */
public class lc5563 {

    //https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls/solution/xiao-shou-jie-zhi-jian-shao-de-yan-se-qiu-by-zerot/

    // 二分
    //对于所有数量 > x 的颜色，其肯定会减小到 x，因此用等差数列求和公式求和即可。
    //如果执行完第 1 步，仍有剩余的 orders，则这些 orders 一定会以价格 x 卖出。
    //
    //作者：newhar
    //链接：https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls/solution/liang-chong-si-lu-you-hua-tan-xin-suan-fa-you-hua-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxProfit1(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long res = 0;
//        int mod = 1000_000_007;
        long mod = (long) (1e9 + 7);

        int lo = 0, hi = Arrays.stream(inventory).max().getAsInt();
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (check(inventory, mid, orders)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        for (int val : inventory) {
            if (val >= lo) {
                res += rangeSum(val, lo + 1);
                res %= mod;
                orders -= val - lo;
            }
        }
        res += lo * (long) orders;
        return (int) (res % mod);
    }

    private long rangeSum(int val, int i) {
        return (long) (val + i) * (val - i + 1) / 2;
    }

    private boolean check(int[] inventory, int mid, int orders) {
        int cnt = 0;
        for (int val : inventory) {
            if (val >= mid) {
                cnt += val - mid;
                if (cnt > orders) return true;
            }
        }
        return false;
    }

    public int maxProfit(int[] inventory, int orders) {
        long res = 0;
        int mod = 1000_000_007;
        if (inventory.length == 1) {
            int num = inventory[0];
            res = (long) (num + num - orders + 1) * orders / 2;
            return (int) (res % mod);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0; i < inventory.length; i++) {
            int num = inventory[i];
            for (int j = num; j >= num - orders + 1 && j >= 0; j--) {
                pq.add(j);
            }
        }

        for (int i = 0; i < orders; i++) {
            res += pq.poll();
        }
        return (int) (res % mod);
    }
}
