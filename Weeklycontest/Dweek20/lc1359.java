package Dweek20;

/**
 * @Classname lc1359
 * @Description
 * @Date 2021/1/13 11:20
 * @Created by j-tooyoung
 */
public class lc1359 {

    // error
    public int countOrders1(int n) {
        long res = 1;
        int mod=1000000007;
        int m = (int) (1e9+ 7) ; // 正确写法
//        int m = (int) (10e9+ 7) ;
        System.out.println(mod - m);
        for (int i = 1; i < n; i++) {
            int cnt = (i + 1) * (2 * i + 1);

            res = (res * cnt) % mod;
        }
        return (int) res;
    }

    int mod=1000000007;
    public int countOrders(int n) {
        long last=1;
        for(int i=1;i<=n;i++){
            //组合 C(2,2*i)
            int c=i*(2*i-1);
            last=(last*c) % mod;
        }
        return (int)last;
    }

}
