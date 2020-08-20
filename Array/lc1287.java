import java.util.HashMap;
import java.util.Map;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
public class lc1287 {

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;

        int target = (len % 4 == 0) ? len / 4 : len / 4 + 1;
        for (int i = 0; i + target < len; i++) {
            if (arr[i] == arr[i + target]) {
                return arr[i];
            }
        }
        return arr[0];
    }

    public int findSpecialInteger1(int[] arr) {
        int n = arr.length;
        int cur = arr[0], cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == cur) {
                ++cnt;
                if (cnt * 4 > n) {
                    return cur;
                }
            }
            else {
                cur = arr[i];
                cnt = 1;
            }
        }
        return -1;

//        int len = arr.length;
//        if (len == 1) return arr[0];
//        Map<Integer, Integer> map = new HashMap<>();
//        int target = (len % 4 == 0) ? len / 4 : len / 4 + 1;
//        for (int i = 0; i < len; i++) {
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//            if (map.get(arr[i]) >= target) {
//                return arr[i];
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {

    }

}
