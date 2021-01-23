package week135;

/**
 * @Classname lc1037
 * @Description
 * @Date 2021/1/22 11:12
 * @Created by j-tooyoung
 */
public class lc1037 {

    public boolean isBoomerang(int[][] points) {
        int a = points[1][0] - points[0][0];
        int b = points[1][1] - points[0][1];
        int c = points[2][0] - points[0][0];
        int d = points[2][1] - points[0][1];

        return !((a * d - c * b) == 0);
    }
}
