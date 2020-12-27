package Dweek43;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5622 {

    public double averageWaitingTime(int[][] customers) {
        int len = customers.length;
        double res = customers[0][1];
        int time = customers[0][0] + customers[0][1];
        for (int i = 1; i < len; i++) {
            if ((time <= customers[i][0])) {
                res = res + customers[i][1] ;
                time =customers[i][0] +  customers[i][1];
            } else {
                res = res + time + customers[i][1] - customers[i][0];
                time =time + customers[i][1];
            }
        }

        return res / len;

    }

}
