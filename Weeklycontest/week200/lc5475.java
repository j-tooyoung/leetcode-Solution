package week200;

/**
 * 5475. 统计好三元组
 * https://leetcode-cn.com/contest/weekly-contest-200/problems/count-good-triplets/
 */
public class lc5475 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
