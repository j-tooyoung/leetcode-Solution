import java.util.Arrays;

/**
 *
 */
public class majorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        int cnt = 0;
        int res = nums[0];
        for (int val : nums) {
            if (val == res) cnt++;
            else cnt--;
            System.out.println(cnt);

//            if (cnt <= 0) { 错误
            if (cnt <= 0) {
                cnt = 0;
                res = val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        System.out.println(new majorityElement().majorityElement1(nums));

    }
}
