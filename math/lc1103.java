/**
 * 1103. 分糖果 II
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 */
public class lc1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int idx = 0;
        int[] res = new int[num_people];
        int cnt = 1;
        while (candies > 0) {
            res[idx] += (candies >= cnt) ? cnt : candies;
            candies -= cnt;
            cnt++;
            idx = (idx + 1) % num_people;
        }
        return res;
    }
}
