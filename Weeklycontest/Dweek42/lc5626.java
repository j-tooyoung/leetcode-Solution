package Dweek42;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5626 {

    public int minPartitions(String n) {
        int res = n.charAt(0);

        for (int i = 1; i < n.length(); i++) {
            res = Math.max(res, n.charAt(i));
        }
        return res - '0';
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
