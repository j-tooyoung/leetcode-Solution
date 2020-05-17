package Dweek26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode-cn.com/contest/biweekly-contest-26/problems/simplified-fractions/
public class lc5397 {

    // 暴力超时
    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        Set<String> st = new HashSet<>();
        if (n == 1) return res;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ( gcd(i,j) > 1) continue;
//                    System.out.println(j+"/"+i);
                if (!st.contains(j + "/" + i)) {
                    res.add(j + "/" + i);
                } else {
                    st.add(j + "/" + i);
                }

            }
        }
        return res;
    }

    private static int gcd(int i, int j) {
        return j == 0 ? i : gcd(j, i % j);
    }

    public static void main(String[] args) {
//        System.out.println(gcd(4, 1));
//        System.out.println(gcd(6, 2));
        for (int i = 1; i < 10; i++) {
            System.out.println(simplifiedFractions(i).toString());
        }
//        int i = 1, j = 2;
//        System.out.println(j+"/"+i);

//        System.out.println(simplifiedFractions(3).toString());

    }

}
