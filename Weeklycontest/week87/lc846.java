package week87;

import java.util.*;

/**
 * @Classname lc846
 * @Description
 * @Date 2021/1/14 10:34
 * @Created by j-tooyoung
 */
public class lc846 {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W !=0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        int cnt = 0;
        int min = map.firstKey();
        while (!map.isEmpty()) {
            if (map.getOrDefault(min, 0) == 0) {
                return false;
            } else {
                if (map.get(min) == 1) {
                    map.remove(min);
                } else {
                    map.put(min, map.get(min) - 1);
                }
            }
            min++;
            cnt++;
            if (cnt == W) {
                cnt = 0;
                if (map.isEmpty()) {
                    return true;
                }
                min = map.firstKey();
            }
        }
        return true;
    }
}
