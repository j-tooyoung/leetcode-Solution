package week191;

import java.util.Arrays;

/**
 * 5425. 切割后面积最大的蛋糕
 * https://leetcode-cn.com/contest/weekly-contest-191/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class lc5425 {
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
       final long mod = 1000000007;
        // 法2 ：不需要创建新数组，直接计算出最大maxRow，maxCol
        int[] row = new int[horizontalCuts.length + 1];
        int[] col = new int[verticalCuts.length + 1];
        long maxRow = row[0];
        long maxCol = col[0];
        long res = Long.MIN_VALUE;
        for (int i = 0; i <= horizontalCuts.length; i++) {
            if (i == 0){ row[0] = horizontalCuts[0];}
            else if(i == horizontalCuts.length) row[i] = h - horizontalCuts[i - 1];
            else{ row[i] = horizontalCuts[i] - horizontalCuts[i - 1];}
            maxRow = Math.max(maxRow, row[i]);
        }
        for (int i = 0; i <= verticalCuts.length; i++) {
            if (i == 0) col[0] = verticalCuts[0];
            else if(i == verticalCuts.length) col[i] = w - verticalCuts[i - 1];
            else col[i] = verticalCuts[i] - verticalCuts[i - 1];
            maxCol = Math.max(maxCol, col[i]);
        }

//        for (int i = 0; i < row.length; i++) {
//            res = Math.max(res, row[i] * maxCol);
//            System.out.println(row[i] * maxCol +"," + maxCol);
//        }
        return (int) (maxCol * maxRow % mod);
//        return (int) (res % (10 ^ 9 + 7));  错误
    }

    public static void main(String[] args) {
        int h = 5, w = 4;
        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};
        System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
        System.out.println(Long.MAX_VALUE);


    }

}
