import java.util.*;

/**
 * ClassName: lc279
 * Package: PACKAGE_NAME
 * Description:
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 *  https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode/
 *
 *
 * @date: 2020/4/8 22:59
 * @author: tooyoung
 */

public class lc279 {

    public static int numSquares(int n) {
        if (n <= 3) return n;
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                res = Math.min(res, 1 + dp[i - j * j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }

    // dp
    public static int numSquares1(int n) {
        if (n <= 3) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                res = Math.min(res, 1 + dp[i - j * j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }

    // bfs  超时
    public static int numSquares2(int n) {
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        Set<Integer> set = new HashSet<>();
        q.add(n);
        set.add(n);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                if (num == 0) return res;
                for (int j = 1; j * j <= num; j++) {
                    int tmp = num - j * j;
                    //已经访问过的不再加入队列
                    if (!set.contains(tmp)) {
                        q.add(tmp);
                        set.add(tmp);
                    }

                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(numSquares1(4));
//        System.out.println(numSquares1(4));
//        System.out.println(numSquares1(3));
        System.out.println(numSquares(5));
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));

    }

}
