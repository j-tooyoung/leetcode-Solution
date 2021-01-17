package week224;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5653 {

    public int countGoodRectangles(int[][] rectangles) {
        int[] ans = new int[rectangles.length];
        int maxVal = 0;
        for (int i = 0; i < rectangles.length; i++) {
            ans[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            maxVal = Math.max(maxVal, ans[i]);
        }
        int cnt = 0;
        for (int an : ans) {
            if (an == maxVal) {
                cnt++;
            }
        }

        return cnt;
    }
}


