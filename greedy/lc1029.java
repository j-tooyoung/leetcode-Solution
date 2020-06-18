import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. 两地调度
 * https://leetcode-cn.com/problems/two-city-scheduling/
 */
public class lc1029 {

    public static int twoCitySchedCost(int[][] costs) {
        int res = 0;
//        按照 price_A - price_B 从小到大排序；
//        将前 N 个人飞往 A 市，其余人飞往 B 市，并计算出总费用。
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                System.out.println(o1[0] +" " + o1[1]);
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        for (int[] list : costs) {
            System.out.println(Arrays.toString(list));
        }
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
//        for (int i = 0; i < n; i++) {
//            res += costs[i][0];
//        }
//        for (int i = n; i < costs.length; i++) {
//            res += costs[i][1];
//        }
        return res;
    }

    public static void main(String[] args) {

    }

}
