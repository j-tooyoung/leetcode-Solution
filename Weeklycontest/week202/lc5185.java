package week202;

/**
 * 5185. 存在连续三个奇数的数组
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/three-consecutive-odds/
 */
public class lc5185 {

    public boolean threeConsecutiveOdds(int[] arr) {
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                cnt++;
                if (cnt == 3) {
                    flag = true;
                    return flag;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
