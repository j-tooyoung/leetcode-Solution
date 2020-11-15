package Dweek39;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname lc5573
 * @Description
 * 5552. 到家的最少跳跃次数
 *
 * @Date 2020/11/8 22:13
 * @Created by j-tooyoung
 */
public class lc5552 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x ==0)return 0;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
//        Set<Integer> vis = new HashSet<>();
        for (int val : forbidden) {
            set.add(val);
        }
        int N = 200000 + 10;
        boolean[][] vis = new boolean[N][2];

        int ans = 0;
        q.add(new int[]{0, 1});
        vis[0][1] = true;
        vis[0][0] = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] num = q.poll();
                int val = num[0];
                int flag = num[1];
                // System.out.println(val);
                // why ??? todo
                if (val + a < 200000 + 10 && !vis[val + a][1] && !set.contains(val + a)) {
                    if (val + a == x) {
                        return ans +1;
                    }
                    vis[val + a][1] = true;
                    q.add(new int[]{val + a, 1});
                }

                if (val - b >= 0 && !vis[val - b][0] && !set.contains(val - b)) {
                    if (flag != 0) {
                        if (val - b == x) {
                            return ans + 1;
                        }
                        q.add(new int[]{val - b, 0});
                        vis[val - b][0] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private int gcd(int a, int b) {
        if (a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        return b > 0 ? gcd(b, a % b) : a;
    }
}
