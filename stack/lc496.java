import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: lc496
 * Package: PACKAGE_NAME
 * Description:
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * @date: 2020/4/8 23:12
 * @author: tooyoung
 */

public class lc496 {

    // 单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        return nums1;
    }

        // 暴力法
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < len; i++) {
            int j;
            for (j = map.get(nums2[i]) + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    res[idx++] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) res[idx++] = -1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
