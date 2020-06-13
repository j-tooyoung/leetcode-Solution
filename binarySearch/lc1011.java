/**
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class lc1011 {

    public static int shipWithinDays(int[] weights, int D) {
        // l, r运载能力越大，所需次数越小
        // 先找出上下限
        //下限：最低运载能力 >= max(weights[i]),保证每天的运载量不超过运载能力
        //上限：最高运载能力 <= sum(weights[i]),不超出包裹总重量

        int l = Integer.MIN_VALUE, r = 0;
        for (int val : weights) {
            r += val;
            l = Math.max(l, val);
        }
//        System.out.println(r);
//        System.out.println(l);
        while (l < r) {
            int mid = l + r >> 1;
            if (!possible(weights, mid, D)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

//    计算出来需要的天数是否小于等于D
    private static boolean possible(int[] weights, int mid, int d) {
        // 最后一组无法计数
        int cnt = 1;
        int len = weights.length;
        int i = 0;
        while (i < len) {
            int tempSum = 0;
            while (i < len) {
                if (tempSum + weights[i] > mid) {
                    cnt++;
                    break;
                } else {
                    tempSum += weights[i];
                }
                i++;
            }
        }
        return cnt <= d;
    }

    public static int shipWithinDays1(int[] weights, int D) {
        int l = Integer.MIN_VALUE, r = 0;
        for (int val : weights) {
            r += val;
            l = Math.max(l, val);
        }
        while (l < r) {
//            int mid = l + r >> 1;
            int mid = l + (r-l) >> 1;
            if (!possible1(weights, mid, D)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    //    计算出来需要的天数是否小于等于D
    private static boolean possible1(int[] weights, int mid, int d) {
        // 当前能承载的数量
        int cur = mid;
        for (int weight : weights) {
            if (mid < weight) return false;
            if (cur < weight) {
                cur = mid;
                d--;
            }
            cur -= weight;
        }
//        System.out.println(cur);
        //d =0 死循环 最后还有一个数
        return d > 0;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays1(weights, 5));
//        System.out.println(possible(weights, 5,5));
        int[] weights1 = {3,2,2,4,1,4};
        System.out.println(shipWithinDays1(weights1, 3));
        int[] weights2 = {1,2,3,1,1};
        System.out.println(shipWithinDays1(weights2, 4));

    }
}
