package week96;

import java.util.Arrays;

/**
 * 881. 救生艇
 * https://leetcode-cn.com/contest/weekly-contest-96/problems/boats-to-save-people/
 * 贪心
 */
public class lc881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res++;
        }
        return res;
    }

}
