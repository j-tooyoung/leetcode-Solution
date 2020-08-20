import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class lc1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Integer[] arr = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) && map.containsKey(o2)) {
                    return map.get(o1) - map.get(o2);
                } else if (map.containsKey(o1)) {
                    return -1;
                } else if (map.containsKey(o2)) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
//        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

}
