package week104;

import java.util.*;

/**
 * 914. 卡牌分组
 * https://leetcode-cn.com/contest/weekly-contest-104/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class lc914 {

    // 【4，6，8】 true
    // 【2，2，3】 false
    // 【404，20，26】

    public boolean hasGroupsSizeX(int[] deck) {
        int[] cnt = new int[10000];
        for(int val : deck){
            cnt[val]++;
        }
        int x = 0;
        for(int val : cnt){
            if(val > 0){
                x = gcd(x,val);
                if(x == 1) return false;
            }
        }
        return x >= 2;
    }

    public boolean hasGroupsSizeX1(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deck) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int minCnt = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val < 2) {
                return false;
            }
            if (!set.contains(val)) {
                set.add(val);
                list.add(val);
            }
            minCnt = Math.min(minCnt, val);
        }
        if (list.size() < 2){ return true;}
        if (list.size() == 2) return gcd(list.get(0), list.get(1)) != 1;
        Collections.sort(list);
        int gcd = gcd(list.get(0), list.get(1));
        if (gcd == 1) return false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + gcd);
            if (entry.getValue() % gcd != 0) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int v1, int v2) {
        return v2 == 0 ? v1 : gcd(v2, v1 % v2);
    }

}
