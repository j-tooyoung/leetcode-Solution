package week192;

import java.util.*;

/**
 *
 */
public class lc5429 {

    //
    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        Integer[] arr1 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        int len = arr.length;
        int m = arr[(arr.length - 1) / 2];
        System.out.println(m);
        int[] res = new int[k];
        // 自定义排序
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - m) < Math.abs(o2 - m)) {
                    return 1;
                }
                if (Math.abs(o1 - m) == Math.abs(o2 - m) && o1 < o2) {
                    return 1;
                }
                return -1;
            }
        });
//        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < k; i++) {
            res[i] = arr1[i];
        }
        return res;
    }

    //    算法2 （排序 + 双指针）
    public static int[] getStrongest1(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(arr.length - 1) / 2];
//        System.out.println(m);
        int[] res = new int[k];
        int l = 0, r = len - 1;
        while (k-- > 0) {
            if (Math.abs(arr[r] - m) >= Math.abs(arr[l] - m)) {
                res[k] = arr[r--];
            } else {
                res[k] = arr[l++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(getStrongest1(arr, 2)));
    }
}
