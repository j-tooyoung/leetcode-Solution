import java.util.*;

/**
 * 面试题 16.11. 跳水板
 * https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class lc16_11 {

//    static Set<Integer> set;
    public static int[] divingBoard(int shorter, int longer, int k) {
//        set = new TreeSet<>();
        int[] res = new int[k + 1];
        if (k==0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        for (int i = 0; i <= k; i++) {
//            set.add(shorter * i + longer * (k - i));
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
//        int[] res = new int[set.size()];
//        int idx = 0;
//        for (int val : set) {
//            res[idx++] = val;
//        }
//        return res;
//        return set.stream().mapToInt(Integer::intValue).toArray();
    }



    public static void main(String[] args) {

        System.out.println(Arrays.toString(divingBoard(1, 2, 3)));
    }

}
