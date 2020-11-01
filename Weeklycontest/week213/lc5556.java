package week213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname lc5523
 * @Description 5556. 可以到达的最远建筑
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/furthest-building-you-can-reach/
 * @Date 2020/10/25 23:44
 * @Created by j-tooyoung
 */
public class lc5556 {

    // 解法正确性 ？？？ todo
    // 错误 梯子肯定是用来高度差最大的那个啊
    // 二分 + 贪心
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int lo = 0, hi = heights.length -1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (check(heights, bricks, ladders, mid)) {
                lo = mid ;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean check(int[] heights, int bricks, int ladders, int mid) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= mid; i++) {
            list.add(heights[i] - heights[i - 1]);
        }
        Collections.sort(list);
//   for (Integer integer : list) {
//             System.out.print(integer+" ");
//         }
//         System.out.println();
        int idx = list.size() - 1;
        while (idx >= 0 && list.get(idx) > 0) {
            while (ladders > 0) {
                ladders--;
                idx--;
            }
            if (idx >= 0 && bricks >= 0 && list.get(idx) <= 0) {
                return true;
            }
            if (idx >= 0) {
                bricks -= list.get(idx--);
            }
        }
        // System.out.println(bricks + " " + mid);

        return bricks >= 0;
    }

    /**
     * 显然，在一段旅程中，需要将梯子用在差距较大的楼层之间。
     * 此时，这个问题就变成了求动态前 k 大，梯子的个数就是 k。前 k 大的高度差使用梯子，剩余的高度差使用砖块。
     * 维护一个小跟堆，每次需要爬升时，先使用梯子。
     * 如果梯子不够用了，从判断当前的高度差是否大于小根堆的堆顶。如果大于，则用砖块替换小跟堆的堆顶所使用的梯子，当前新的高度差使用梯子；否则当前新的高度差使用砖块。
     * 使用砖块时，判断一下砖块是否够用。
     *
     * @param heights
     * @param bricks
     * @param ladders
     * @return
     */
    public int furthestBuilding1(int[] heights, int bricks, int ladders) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(3);
//        nums.add(2);
//        pq.addAll(nums);
//        System.out.println(pq.peek());

        int len = heights.length;
        for (int i = 1; i < len; i++) {
            if (heights[i] > heights[i - 1]) {
                int diff = heights[i] - heights[i - 1];
                if (ladders > 0) {
                    ladders--;
                    pq.add(diff);
                } else {
                    if (!pq.isEmpty() && diff > pq.peek()) {
                        if (bricks < pq.peek()) {
                            return i - 1;
                        }
                        bricks -= pq.peek();
                        pq.poll();
                        pq.add(diff);
                    } else {
                        if (bricks < diff) {
                            return i - 1;
                        }
                        bricks -= diff;
                    }
                }
            }
        }
        return len - 1;
    }

    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        int[] dp = new int[heights.length];
        int i;
        for (i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                if (bricks >= (heights[i] - heights[i - 1])) {
                    bricks -= (heights[i] - heights[i - 1]);
                } else {
                    ladders--;
                    if (ladders<0) break;
                }
            }
        }
        return i;
    }

}
