package fallContest2020;

/**
 * https://leetcode-cn.com/contest/season/2020-fall/problems/UlBDOe/
 * 3. 秋叶收藏集
 */
public class c3 {

    public int minimumOperations(String leaves) {
        int len = leaves.length();
        int res = 0;
        int i = 0;
        int j = leaves.length() - 1;
        //


        while (i < len && leaves.charAt(i++) == 'r') { }
        while (j >= 0 && leaves.charAt(j--) == 'r') { }
        if (i == 0) {
            res++;
            i++;
        }
        if (j == 0) {
            res++;
            j--;
        }
        if (i >= j) return 0;
        // 左侧和右侧均大于1
        while (i < j) {
            while (i < j && leaves.charAt(i) == 'y') i++;
            while (i < j && leaves.charAt(j) == 'y') j--;
            if (i < j) {
                res += 2;
                i++;
                j--;
            }
        }
        return res;
    }
}
