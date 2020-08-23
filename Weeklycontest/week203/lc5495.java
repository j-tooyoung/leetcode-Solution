package week203;

import java.util.*;

/**
 * 5495. 圆形赛道上经过次数最多的扇区
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/most-visited-sector-in-a-circular-track/
 */
public class lc5495 {

    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[n + 1];
        int len = rounds.length;
        for (int i = 0; i < rounds.length - 1; i++) {
            // 循环遍历，如果start > end,则需减一,
            //
            int start = rounds[i];
            int end = rounds[i + 1];
            while (start != end) {
                cnt[start]++;
                start++;
                if (start > n) start -= n;
            }
        }
        cnt[rounds[len - 1]]++;
        int maxVal = 0;
        for (int i = 1; i < cnt.length; i++) {
//            maxVal = Math.max(maxVal, cnt[i]);
            System.out.println(i + " " + cnt[i]);
            if (cnt[i] > maxVal) {
                maxVal = cnt[i];
                res.clear();
             res.add(i);
            } else if (cnt[i] == maxVal) {
                res.add(i);
            }
        }
        return res;
    }

    // 只需看首尾
    public static List<Integer> mostVisited1(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int len = rounds.length;
        int start = rounds[0];
        int end = rounds[len - 1];
        if (start == end + 1 || (start == 1 && end == n)) {
            for (int i = 1; i <= n; i++) {
                res.add(i);
            }
        } else {
            while (start != end) {
                res.add(start);
                if (++start > n) {
                    start -= n;
                }
            }
            res.add(end);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] round = {1, 3, 1, 2};
        int[] round4 = {2,1,2,1,2,1,2,1,2};
        int[] round1 = {1, 2,1};
        int[] round2 = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] round3 = {1,3,5,7};

        System.out.println(mostVisited(2, round4));
//        System.out.println(mostVisited(4, round));
//        System.out.println(mostVisited(2, round1));
//        System.out.println(mostVisited(2, round2));
//        System.out.println(mostVisited(7, round3));
    }

}
