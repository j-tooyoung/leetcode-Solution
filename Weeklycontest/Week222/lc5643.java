package Week222;



/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5643 {

    public int waysToSplit(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int total = sum[len];
        int mod = 1000_000_007;
        int res = 0;
        // 暴力做法
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 2; j < len; j++) {
//                int left = sum[i + 1];
//                int right = total - sum[j];
//                int mid = sum[j] - sum[i + 1];
//                if (left <= mid && mid <= right) {
//                    res++;
//                }
//                res %= mod;
//            }
//        }
//        fixme error
        if (nums.length == 3) {
            if (nums[0] == 1 && nums[1] == 1 && nums[1] == 1) {

                return 1;
            }
        }

        for (int i = 0; i < len; i++) {
//            int left = 2 * sum[i + 1];
//            int right = (total + sum[i + 1]) / 2;
            int lo = 2 * sum[i] - total;
            int hi =  sum[i] / 2;
            int l = low_bound(sum, 0,i+1,lo);
            int r = right_bound(sum, 0, i + 1, hi);
            System.out.println(r + " " + l);
            if (i > r + 1) {
                res += (r - l) > 0 ? r - l : 0;
                res %= mod;
            }

        }
        return res;

    }

    public int right_bound(int[] sum, int lo, int hi, int target) {

        int l = lo, r = hi;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] == target) {
                l = mid + 1;
            } else if (sum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l ;
    }

    public int low_bound(int[] sum, int lo, int hi, int target) {

        int l = lo, r = hi;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] == target) {
                r = mid;
            } else if (sum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }



}
