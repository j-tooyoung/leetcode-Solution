package Dweek44;

import java.util.*;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5646 {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int ans = 0;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < friendships.length; i++) {
            int a = friendships[i][0] - 1;
            int b = friendships[i][1] - 1;
            List<Integer> tmp1 = new ArrayList<>();
            List<Integer> tmp2 = new ArrayList<>();
            boolean flag = false;
            Set<Integer> set = new HashSet<>();
            for (int num : languages[a]) {
                tmp2.add(num);
                set.add(num);
            }
            for (int num : languages[b]) {
                if (set.contains(num)) {
                    flag = true;
                }
                tmp1.add(num);
            }
            if (!flag) {
                System.out.println(a+" "+b);
                ans++;
//                list.get(a).addAll(tmp2);
//                list.get(b).addAll(tmp1);
            }


        }
        return ans;
    }

}
