package week202;

import java.util.Arrays;

/**
 * 5489. 两球之间的磁力
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/magnetic-force-between-two-balls/
 *
 */
public class lc5489 {

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        // 能放置的最大和最小距离
        int i = 1, j = (position[len - 1] - position[0]) / (m-1);
        while (i < j) {
            int dist = (i + j  + 1) >> 1;
            if (canPut(position, dist,m)) {
                i = dist;
            } else {
                j = dist - 1;
            }
        }
        return i;
    }

    private static boolean canPut(int[] position, int dist, int m) {
        int cnt = 1;
        int start = 0;
        int end = 1;
        while (end < position.length) {
            if (position[end] - position[start] >= dist) {
                cnt++;
                start = end;
                if (cnt >= m) return true;
            }
            end++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7};
        int[] arr1 = {5,4,3,2,1,1000000000};
        int[] arr2 = {4, 3, 2, 1, 50000, 1000000000};
//        System.out.println(maxDistance(arr,3));
        System.out.println(maxDistance(arr, 4));
//        System.out.println(maxDistance(arr1, 2));
//        System.out.println(maxDistance(arr1, 3));
        System.out.println(maxDistance(arr2, 2));
        System.out.println(maxDistance(arr2, 3));
    }

}
