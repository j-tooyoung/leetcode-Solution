package Dweek43;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5633 {

    public int totalMoney(int n) {
        int res = 0;
        int st = 1;
        for (int i = 0; i < n; i++) {
            res += st;
            st += 1;
            if ((i + 1) % 7 == 0) {
                st -= 6;
            }
        }
        return res;
    }


}


