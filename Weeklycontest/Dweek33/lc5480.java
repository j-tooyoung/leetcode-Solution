package Dweek33;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 5480. 可以到达所有点的最少点数目
 * https://leetcode-cn.com/contest/biweekly-contest-33/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class lc5480 {

    // 寻找入度为0的点
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            set.add(edges.get(i).get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

}
