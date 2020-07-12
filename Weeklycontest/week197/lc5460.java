package week197;

public class lc5460 {

    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == nums[i]) {
                    res++;
                }
            }
        }
        return res;
    }
}
