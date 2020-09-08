package Week204;

/**
 * @Classname lc5449
 * @Description TODO
 * @Date 2020/8/30 10:35
 * @Created by xp123
 * 5499. 重复至少 K 次且长度为 M 的模式
 * https://leetcode-cn.com/contest/weekly-contest-204/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 */
public class lc5449 {

    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        int need = m * k;
        if (need > len) {
            return false;
        }
//[2,2]
//        1
//        2
        for (int i = 0; i + need <= len; i++) {
            int start = i;
            boolean flag = true;
            for (int j = start; j < i + need - m; j++) {
                if (arr[j] != arr[j + m]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }

}
