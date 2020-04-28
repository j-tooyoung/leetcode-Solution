package main.sort;

import java.util.*;

/**
 * ClassName: let40
 * Package: main.sort
 * Description:
 * 最小的k个数
 * @date: 2020/3/20 16:28
 * @author: tooyoung
 */

public class let40 {

    public static void main(String[] args) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        return qSort(arr, 0, arr.length - 1, k - 1);
    }

    private int[] qSort(int[] arr, int l, int r, int k) {
        int j = partition(arr, l, r);
        if (j == k) return Arrays.copyOf(arr, j + 1);
        return (j > k) ? qSort(arr, l, j - 1, k) : qSort(arr, j + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {
        //  if (l >= r) return l;
        int tmp = arr[l];
        int i = l, j = r + 1;
//        while (++i <= r && --j >= l) {
//            while (arr[i] < tmp) ;
//            while ( arr[j] > tmp) ;
//            if (i < j) {
//                int t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
//            }
//        }
        while (true) {
            while (++i <= r && arr[i] < tmp) ;
            while (--j >= l && arr[j] > tmp) ;
            if (i >= j) break;
            int t = arr[j];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[l] = arr[j];
        arr[j] = tmp;
        return j;
    }

    // 法2 堆排
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        //默认小根堆，需重写实现为大根堆
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    //法3 TreeMap
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
            }
            //取出最大值
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                // 只有一个，直接删除
                if (entry.getValue() == 1) map.pollLastEntry();
                else map.put(entry.getKey(), entry.getValue() - 1);
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 错误 key相同
//            if (idx < k) {
//                res[idx++] = entry.getKey();
//            }
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
// 法4 直接计数
}
