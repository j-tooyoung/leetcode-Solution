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
<<<<<<< HEAD
        int len2 = arr2.length;
        int len1 = arr1.length;
        if (arr1 == null || len1 < 1) return arr1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <len2; i++) {
            map.put(arr2[i], i);
        }
        Integer[] arr = new Integer[len1];
        for (int i = 0; i < len1; i++) {
=======
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Integer[] arr = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
>>>>>>> 74c4d7ac2fe419f9c039c3495763a1ca6e7ffe1a
            arr[i] = arr1[i];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) && map.containsKey(o2)) {
                    return map.get(o1) - map.get(o2);
<<<<<<< HEAD
                }  else {
=======
                } else if (map.containsKey(o1)) {
                    return -1;
                } else if (map.containsKey(o2)) {
                    return 1;
                } else {
>>>>>>> 74c4d7ac2fe419f9c039c3495763a1ca6e7ffe1a
                    return o1 - o2;
                }
            }
        });
<<<<<<< HEAD
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
=======
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
//        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
>>>>>>> 74c4d7ac2fe419f9c039c3495763a1ca6e7ffe1a
    }

}
