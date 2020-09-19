package fallContest2;

/**
 * 2. 魔术排列
 * https://leetcode-cn.com/contest/season/2020-fall/problems/er94lq/
 */
public class lc_b {

    public boolean isMagic(int[] target) {
        int i = 0;
        int num = 2;
        while (target[i] == num) {
            i++;
            num += 2;
        }
        int len = target.length;
//        if(i % len + )
        return false;

//        return false;
    }
}
