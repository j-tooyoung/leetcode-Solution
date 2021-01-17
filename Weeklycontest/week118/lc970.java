package week118;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname lc970
 * @Description
 * @Date 2021/1/16 14:50
 * @Created by j-tooyoung
 */
public class lc970 {
    // y= 1 导致死循环
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int i = 0, j = 0;
        if (x == 1) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        while (i <= bound) {
            int ans = (int) Math.pow(x, i);
            // System.out.println(ans);

            if (ans > bound) {
                break;
            }
            int begin = 1;
            int tmp = ans;
            while (tmp + begin <= bound) {
                if (!set.contains(tmp + begin)) {
                    res.add(tmp + begin);
                }
                set.add(tmp + begin);
                begin *= y;
                if (y == 1) {
                    break;
                }
            }
            i++;
        }
        return res;
    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
//        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
//            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
//                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
//                if (v <= bound)
//                    seen.add(v);
//            }
        for (int i = 0; i < bound; i *= x) {
            for (int j = 0; i + j < bound; j *= y) {
                seen.add(i + j);
                if (j == 1) {
                    break;
                }
            }
        }

        return new ArrayList(seen);
    }

}
