/**
 *
 */
public class lc0803 {

    // 二分
    public int findMagicIndex(int[] nums) {

        return -1;
    }

    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }



}
