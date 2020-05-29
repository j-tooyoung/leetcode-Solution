import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class lc57_ {
    public static int[][] findContinuousSequence(int target) {
        // 有问题
        List<int[]> res = new ArrayList<>();
        int[] path;
        for (int i = 1; i <= target / 2; i++) {
            int tmp = ((int) Math.sqrt(1 - 4 * (-i * i + i - 2 * target)) - 1) / 2;
//            System.out.println(tmp);
            if ((i + tmp) / 2 * (tmp - i + 1) == target) {
                path = new int[tmp - i + 1];
                for (int j = 0; j < path.length; j++) {
                    path[j] = j + i;
                }
                res.add(path);
            }
        }
        int[][] tmp = new int[res.size()][];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = res.get(i);
        }
        return tmp;
    }

    public static void main(String[] args) {
//        System.out.println(9/2);
//        System.out.println(9/2 + 1);
        for (int i = 9; i <= 9; i++) {
            int[][] res = findContinuousSequence(i);
            for (int[] path : res) {
                System.out.print("[");
//                Arrays.stream(path).forEach(System.out::println);
                for (int val : path) {
                    System.out.print(val+",");
                }
                System.out.println("]");
            }
        }
    }
}
