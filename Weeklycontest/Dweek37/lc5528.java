package Dweek37;

/**
 * @Classname lc5140
 * @Description
 * @Date 2020/10/4 13:55
 * @Created by j-tooyoung
 */
public class lc5528 {

    //[[28,6,30],[23,16,0],[21,42,22],[50,33,34],[14,7,50],[40,31,4],[39,45,17],[46,21,12],[45,36,45],[35,43,43],[29,41,48],[22,27,5],[42,44,45],[10,49,50],[47,43,26],[40,36,25],[10,25,6],[27,30,30],[50,35,20],[11,0,44],[34,29,28]]
    //12
    public int[] bestCoordinate(int[][] towers, int radius) {
        double maxVal = 0;
        int[] ans = new int[2];
//        ans[0] = Integer.MAX_VALUE;
        int row = towers.length;
        for (int i = 0; i <= 50; i++) {
            double sum = 0;
            for (int j = 0; j <= 50; j++) {
                for (int k = 0; k < row; k++) {
                    double distance = Math.sqrt((towers[k][0] - i) * (towers[k][0] - i) + (towers[k][1] - j) * (towers[k][1] - j));
                    if (distance <= radius) {
                        sum += Math.floor(towers[k][2] / (1 + distance));
                    }
                }

//                if (i == 45) {
//                    System.out.println(i + " " + j + " " + sum);
//                }
//                if (i == 42) {
//                    System.out.println(i + " " + j + " " + sum);
//                }
////                42 44 66.09376680358577
////                45 36 67.21252885543204

                if (maxVal < sum) {
                    maxVal = sum;
                    ans[0] = i;
                    ans[1] = j;
                } else if (maxVal == sum) {
                    if (compare(ans, i, j)) {
                        continue;
                    }
                    ans[0] = i;
                    ans[1] = j;

                }
            }
        }
        return ans;

    }

    private boolean compare(int[] ans, int i, int j) {
        if (ans[0] < i) {
            return true;
        } else if (ans[0] == i) {
            return ans[1] < j;
        }
        return false;
    }

}
