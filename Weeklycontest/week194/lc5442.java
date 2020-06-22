package week194;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 5442. 避免洪水泛滥
 * https://leetcode-cn.com/contest/weekly-contest-194/problems/avoid-flood-in-the-city/
 */
public class lc5442 {

    public static int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] res = new int[len];
        LinkedList<Integer> st = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {
                res[i] = -1;
                if (map.containsKey(rains[i])) {
                    if (map.get(rains[i]) > 1) return new int[]{};
                }
                map.put(rains[i], map.getOrDefault(rains[i], 0) + 1);
                st.push(i);
            } else if (rains[i] == 0) {

            }
        }
        return res;

//        boolean flag = false;
//        for (int val : res) {
//            if (val != -1) flag = true;
//        }
//        return flag ? res : new int[]{};
    }

    public static void main(String[] args) {
//[1,2,3,4]
//[1,2,0,0,2,1]
//[1,2,0,1,2]
//[69,0,0,0,69]
//[10,20,20]
    }
}
