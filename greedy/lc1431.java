import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class lc1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            maxVal = Math.max(maxVal, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxVal) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
