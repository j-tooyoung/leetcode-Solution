import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]);
            for (int j = idx; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;      // 必须break
                }
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = new nextGreaterElement().nextGreaterElement(nums1, nums2);
        for (int val : res) {
            System.out.print(val+" ");
        }
        System.out.println();
    }

}
