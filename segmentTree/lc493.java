/**
 * @Classname lc493
 * @Description
 * @Date 2020/11/28 10:11
 * @Created by j-tooyoung
 */
public class lc493 {
    public int reversePairs(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((long)nums[i]  > 2* (long)nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //归并排序
    public int reversePairs1(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + hi >> 1;
        int res = merge(nums, lo, mid) + merge(nums, mid + 1, hi);
        int i = lo, j = mid + 1;
        while (i <= mid ) {
            while (j <= hi && (long)nums[i] > 2* (long)nums[j]) {
                j++;
            }
            res += (j - mid - 1);
            i++;
        }
        int[] tmp = new int[hi - lo + 1];
        i = lo; j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] < nums[j]) {
                tmp[idx++] = nums[i++];
            } else {
                tmp[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[idx++] = nums[i++];
        }
        while (j <= hi) {
            tmp[idx++] = nums[j++];
        }
        for (int k = lo; k <= hi; k++) {
            nums[k] = tmp[k - lo];
        }
        return res;
    }

}
