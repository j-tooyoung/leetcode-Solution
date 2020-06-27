import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class lc57_ii {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int[] path ;
        int l = 1;
        int r = l;
        int sum = 0;
        while (l <= (target / 2)) {
            //滑动窗口，
            while (sum > target) {
                sum -= l;
                l++;
            }
            if (sum == target) {
                path = new int[r - l ];
                for (int i = l; i < r; i++) {
                    path[i - l] = i;
                }
                res.add(path);
            }
            sum += r;
            r++;
        }
        int[][] tmp = new int[res.size()][];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = res.get(i);
        }
        return tmp;
    }

    // 直接求解
    public static int[][] findContinuousSequence1(int target) {
        List<int[]> res = new ArrayList<>();
         int[] path;
        for (int i = 1; i <= (target / 2); i++) {
            int tmp = ((int) Math.sqrt(1 - 4 * (-i * i + i - 2 * target)) - 1) / 2;
            System.out.println(tmp);
            // System.out.println((i + tmp) / 2 * (tmp - i + 1));
            if ((i + tmp) / 2 * (tmp - i + 1) == target) {
                path = new int[tmp - i + 1];
                int idx = 0;
                for (int j = i; j <= tmp; j++) {
                    path[idx++] = j;
                }
                res.add(path);
            }
        }
        return res.toArray(new int[res.size()][]);//这里不是Integer,results中本来就存储的int[]类型的数据，可以直接调用results.toArray()函数转换

//         int[][] tmp = new int[res.size()][];
//         for (int i = 0; i < tmp.length; i++) {
//             tmp[i] = res.get(i);
//         }
//         return tmp;
    }

    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
        for (int[] seq : res) {
            System.out.println(Arrays.toString(seq));
        }
        System.out.println("   ");
        for (int[] seq : findContinuousSequence(15)) {
            System.out.println(Arrays.toString(seq));
        }

    }
}
