/**
 * @Classname LCP19
 * @Description
 * @Date 2021/1/20 22:12
 * @Created by j-tooyoung
 */
public class LCP19 {

    public int minimumOperations(String leaves) {
        int lo = 0;
        int hi = leaves.length() - 1;
        int len = leaves.length();
        while (lo < len && leaves.charAt(lo) == 'r') {
            lo++;
        }
        while (hi >= 0 && leaves.charAt(hi) == 'r') {
            hi--;
        }
        if (lo > hi) {
            return 1;
        }

        int res = 0x3f3f3f;
        int n = hi - lo + 1;
        int[] pre = new int[n+1];
        for (int i = lo; i <= hi; i++) {
            pre[i - lo + 1] = pre[i - lo] + (leaves.charAt(i) == 'y' ? 1 : 0);
        }
        int total = pre[n];
        // 左边r，右边y
        for (int i = lo; i <= hi; i++) {
            int left = pre[i - lo];
            int right = (n - (i - lo)) - (total - pre[i - lo]);

            res = Math.min(res, left + right);
        }
        // System.out.println("n = " + n +" total = " + total);

//        res = Math.min(res, total); // 整个修改为r
        res = Math.min(res,  n-total);  // 整个修改为y
        if (lo == 0) {
            res += 1;
        }
        if (hi == len-1) {
            res += 1;
        }
        return res;
    }

    // fixme error
    public int minimumOperations1(String leaves) {
//        int lo = 0;
//        int hi = leaves.length() - 1;
//        int len = leaves.length();
//        while (lo < len && leaves.charAt(lo) == 'r') {
//            lo++;
//        }
//        while (hi >= 0 && leaves.charAt(hi) == 'r') {
//            hi--;
//        }
//        if (lo > hi) {
//            return 1;
//        }
//
//        int res = 0x3f3f3f;
//        int n = hi - lo + 1;
//        int[] pre = new int[n+1];
//        for (int i = lo; i <= hi; i++) {
//            pre[i - lo + 1] = pre[i - lo] + (leaves.charAt(i) == 'y' ? 1 : 0);
//        }
//        int total = pre[n];
//        // 左边r，右边y
//        for (int i = lo; i <= hi; i++) {
//            int left = pre[i - lo];
//            int right = (n - (i - lo)) - (total - pre[i - lo]);
//
//            res = Math.min(res, left + right);
//        }
//        // System.out.println("n = " + n +" total = " + total);
//
////        res = Math.min(res, total); // 整个修改为r
//        res = Math.min(res,  n-total);  // 整个修改为y
//        if (lo == 0) {
//            res += 1;
//        }
//        if (hi == len-1) {
//            res += 1;
//        }
//        return res;
        return 0;
    }
}
