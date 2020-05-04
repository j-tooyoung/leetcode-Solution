import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class lc5384 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val : candies) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int cnt = 0;
        for (int val : candies) {
            if (val + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 1, 2};
        int num = 1;
        kidsWithCandies(nums, num);

    }

}
