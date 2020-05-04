/**
 * 1281. 整数的各位积和之差
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class lc1281 {


    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            mul *= Integer.valueOf(s.charAt(i) -'0');
            sum += Integer.valueOf(s.charAt(i)-'0');
        }
        return mul - sum;

//        int add = 0, mul = 1;
//        while (n > 0) {
//            int digit = n % 10;
//            n /= 10;
//            add += digit;
//            mul *= digit;
//        }
//        return mul - add;
    }

}
