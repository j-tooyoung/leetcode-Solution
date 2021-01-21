package Dweek25;

/**
 * @Classname lc1432
 * @Description
 * @Date 2021/1/21 9:41
 * @Created by j-tooyoung
 */
public class lc1432 {
    public int maxDiff(int num) {
        if(num<=9 && num>=1) return 8;
        char[] a = String.valueOf(num).toCharArray();
        char[] b = String.valueOf(num).toCharArray();
        char changeNum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != '9') {
                changeNum = a[i];
                break;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == changeNum) {
                a[i] = '9';
            }
        }
        boolean first1 = (b[0] == '1');
        boolean flag = false;
        if (first1) {
            for (int i = 1; i < b.length; i++) {
                if (b[i] != '0' && b[i] != '1') {
                    flag = true;
                    changeNum = b[i];
                    break;
                }
            }
        } else {
            changeNum = b[0];
        }
        // System.out.println("flag = " + flag + " " + "changeNum = " + changeNum);
        for (int j = 0; j < b.length; j++) {
            if (first1 ) {
                if (flag && b[j] == changeNum) {
                    b[j] = '0';
                }
            } else {
                if (b[j] == changeNum) {
                    b[j] = '1';
                }
            }
        }

        int a1 = Integer.valueOf(new String(a));
        int b1 = Integer.valueOf(new String(b));
        // System.out.println("a1 = " + a1 + " " + "b1 = " + b1);

        return a1 - b1;
    }
}
